package lora.ns.kerlink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import c8y.ConnectionState;
import lora.codec.downlink.DownlinkData;
import lora.codec.uplink.C8YData;
import lora.ns.connector.LNSAbstractConnector;
import lora.ns.device.DeviceProvisioning;
import lora.ns.device.EndDevice;
import lora.ns.gateway.Gateway;
import lora.ns.kerlink.dto.ClusterDto;
import lora.ns.kerlink.dto.CustomerDto;
import lora.ns.kerlink.dto.EndDeviceDto;
import lora.ns.kerlink.dto.GatewayDto;
import lora.ns.kerlink.dto.JwtDto;
import lora.ns.kerlink.dto.PaginatedDto;
import lora.ns.kerlink.dto.PushConfigurationDto;
import lora.ns.kerlink.dto.PushConfigurationDto.PushConfigurationMSgDetailLevel;
import lora.ns.kerlink.dto.PushConfigurationDto.PushConfigurationType;
import lora.ns.kerlink.dto.PushConfigurationHeaderDto;
import lora.ns.kerlink.dto.UserDto;

public class KerlinkConnector extends LNSAbstractConnector {

	private static final String CLUSTER_ID = "clusterId";
	private static final String PASSWORD = "password";
	private static final String USERNAME = "username";
	private static final String BASE_URL = "baseUrl";
	private JwtDto jwt = null;
	private Integer customerId = null;
	private String clusterId;
	private String username;
	private String password;
	private String baseUrl;

	private final Logger logger = LoggerFactory.getLogger(KerlinkConnector.class);

	public KerlinkConnector(Properties properties) {
		super(properties);
	}

	public KerlinkConnector(ManagedObjectRepresentation instance) {
		super(instance);
	}

	private void login() {
		RestTemplate restTemplate = new RestTemplate();
		String request = String.format("{\"login\":\"%s\", \"password\":\"%s\"}", username, password);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		jwt = restTemplate.postForObject(baseUrl + "/login", new HttpEntity<String>(request, headers), JwtDto.class);
		logger.info("Received token: {} {}", jwt.getTokenType(), jwt.getToken());
		headers = new HttpHeaders();
		headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
		// UriComponentsBuilder builder =
		// UriComponentsBuilder.fromHttpUrl(properties.getProperty("baseUrl") +
		// "/users")
		// .queryParam("search",
		// "{\"operand\":\"login\",\"operation\":\"EQ\",\"values\":[\"" +
		// properties.getProperty("username") + "\"]}");
		// logger.info("Will call GET {}", builder.toUriString());
		// ResponseEntity<PaginatedDto<UserDto>> users =
		// restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new
		// HttpEntity<String>("", headers), new
		// ParameterizedTypeReference<PaginatedDto<UserDto>>(){});
		ResponseEntity<PaginatedDto<UserDto>> users = restTemplate.exchange(baseUrl + "/users", HttpMethod.GET,
				new HttpEntity<String>("", headers), new ParameterizedTypeReference<PaginatedDto<UserDto>>() {
				});
		if (users.getStatusCode() == HttpStatus.OK) {
			for (UserDto user : users.getBody().getList()) {
				logger.info("Testing user {}", user.getLogin());
				if (user.getLogin().equals(username)) {
					customerId = user.getCustomer().getId();
					logger.info("Customer Id: {}", customerId);
				}
			}
			// customerId =
			// users.getBody().getList().iterator().next().getCustomer().getId();
		}
	}

	public List<EndDevice> getDevices() {
		List<EndDevice> result = new ArrayList<>();
		if (jwt == null || jwt.isExpired()) {
			login();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PaginatedDto<EndDeviceDto>> response = restTemplate.exchange(baseUrl + "/endDevices",
				HttpMethod.GET, new HttpEntity<String>("", headers),
				new ParameterizedTypeReference<PaginatedDto<EndDeviceDto>>() {
				});
		if (response.hasBody()) {
			for (EndDeviceDto endDeviceDto : response.getBody().getList()) {
				result.add(new EndDevice(endDeviceDto.getDevEui(), endDeviceDto.getName(),
						endDeviceDto.getClassType()));
			}
		}
		return result;
	}

	@Override
	public String sendDownlink(DownlinkData operation) {
		if (jwt == null || jwt.isExpired()) {
			login();
		}
		String request = String.format(
				"{\n" + "	\"endDevice\": {\n" + "		\"devEui\": \"%s\"\n" + "	},\n"
						+ "	\"fPort\": %d,\n" + "	\"payload\": \"%s\",\n" + "	\"confirmed\": false,\n"
						+ "	\"contentType\": \"HEXA\"\n" + "}",
				operation.getDevEui(), operation.getFport(), operation.getPayload());
		logger.info("Request: {}", request);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaTypes);
		RestTemplate restTemplate = new RestTemplate();
		logger.info("Will send data to {}", baseUrl + "/dataDown");
		String response = restTemplate.exchange(baseUrl + "/dataDown", HttpMethod.POST,
				new HttpEntity<String>(request, headers), String.class).getHeaders().getLocation().getPath();
		return response.substring(response.lastIndexOf('/') + 1);
	}

	@Override
	public EndDevice getDevice(String devEui) {
		if (jwt == null || jwt.isExpired()) {
			login();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
		RestTemplate restTemplate = new RestTemplate();
		logger.info("Will get device info on URL: {}", baseUrl + "/endDevices/" + devEui);
		EndDeviceDto endDeviceDto = restTemplate.exchange(baseUrl + "/endDevices/" + devEui, HttpMethod.GET,
				new HttpEntity<String>("", headers), EndDeviceDto.class).getBody();
		return new EndDevice(devEui, endDeviceDto.getName(), endDeviceDto.getClassType());
	}

	@Override
	public void provisionDevice(DeviceProvisioning deviceProvisioning) {
		if (jwt == null || jwt.isExpired()) {
			login();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
		headers.set("Content-Type", "application/json,application/vnd.kerlink.iot-v1+json");
		headers.set("Accept", "application/json,application/vnd.kerlink.iot-v1+json");
		RestTemplate restTemplate = new RestTemplate();
		EndDeviceDto dto = new EndDeviceDto();
		dto.setCluster(new ClusterDto());
		dto.getCluster().setId(Integer.parseInt(this.clusterId));
		dto.setDevEui(deviceProvisioning.getDevEUI());
		dto.setClassType("A");
		dto.setAppEui(deviceProvisioning.getAppEUI());
		dto.setAppKey(deviceProvisioning.getAppKey());
		restTemplate.exchange(baseUrl + "/endDevices/" + deviceProvisioning.getDevEUI(), HttpMethod.PUT,
				new HttpEntity<EndDeviceDto>(dto, headers), String.class);
	}

	@Override
	protected void init() {
		this.clusterId = properties.getProperty(CLUSTER_ID);
		this.baseUrl = properties.getProperty(BASE_URL);
		this.username = properties.getProperty(USERNAME);
		this.password = properties.getProperty(PASSWORD);
	}

	@Override
	public void configureRoutings(String url, String tenant, String login, String password) {
		if (jwt == null || jwt.isExpired()) {
			login();
		}
		String routingName = tenant + "-" + this.getId();
		PushConfigurationDto currentPushConfigurationDto = null;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
		RestTemplate restTemplate = new RestTemplate();
		PaginatedDto<PushConfigurationDto> pushConfigurationDtos = restTemplate
				.exchange(baseUrl + "/pushConfigurations", HttpMethod.GET, new HttpEntity<String>("", headers),
						new ParameterizedTypeReference<PaginatedDto<PushConfigurationDto>>() {
						})
				.getBody();
		for (PushConfigurationDto pushConfigurationDto : pushConfigurationDtos.getList()) {
			if (pushConfigurationDto.getName().equals(routingName)) {
				currentPushConfigurationDto = pushConfigurationDto;
			}
		}
		Integer configId = null;
		// if (currentPushConfigurationDto != null) {
		// configId = currentPushConfigurationDto.getId();
		// logger.info("Found existing push configuration {} with id {} and will update
		// it.", currentPushConfigurationDto.getName(),
		// currentPushConfigurationDto.getId());
		// currentPushConfigurationDto.setUrl(url);
		// currentPushConfigurationDto.setUser(tenant+"/"+login);
		// currentPushConfigurationDto.setPassword(password);
		// currentPushConfigurationDto.setHttpDataDownEventRoute("/downlink");
		// currentPushConfigurationDto.setHttpDataUpRoute("/uplink");
		// headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		// List<MediaType> mediaTypes = new ArrayList<MediaType>();
		// mediaTypes.add(MediaType.APPLICATION_JSON);
		// headers.setAccept(mediaTypes);
		// ObjectMapper mapper = new ObjectMapper();
		// MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
		// try {
		// String dto = mapper.writeValueAsString(currentPushConfigurationDto);
		// logger.info("dto = {}", dto);
		// map.add("dto", dto);
		// } catch (JsonProcessingException e) {
		// e.printStackTrace();
		// }
		// HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map,
		// headers);
		// ResponseEntity<String> result =
		// restTemplate.exchange(properties.getProperty("baseUrl") +
		// "/pushConfigurations/" + currentPushConfigurationDto.getId(),
		// HttpMethod.POST, request, String.class);
		// if (result.getStatusCode() != HttpStatus.NO_CONTENT) {
		// logger.error("Something was wrong while updating the push config: {}",
		// result.getBody());
		// configId = null;
		// }
		if (currentPushConfigurationDto == null) {
			currentPushConfigurationDto = new PushConfigurationDto(new CustomerDto(customerId), routingName,
					PushConfigurationType.HTTP, PushConfigurationMSgDetailLevel.NETWORK,
					new PushConfigurationHeaderDto[] {
							new PushConfigurationHeaderDto("Content-Type", "application/json") },
					"/downlink", "/uplink", url, tenant + "/" + login, password);
			logger.info("Will create a new push configuration: {}", currentPushConfigurationDto.toString());
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			List<MediaType> mediaTypes = new ArrayList<>();
			mediaTypes.add(MediaType.APPLICATION_JSON);
			headers.setAccept(mediaTypes);
			ObjectMapper mapper = new ObjectMapper();
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			try {
				String dto = mapper.writeValueAsString(currentPushConfigurationDto);
				logger.info("dto = {}", dto);
				map.add("dto", dto);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
			ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/pushConfigurations", HttpMethod.POST,
					request, String.class);
			String[] tokens = response.getHeaders().getLocation().getPath().split("/");
			configId = Integer.parseInt(tokens[tokens.length - 1]);
		}
		if (configId != null) {
			this.setProperty("configId", configId);
			headers = new HttpHeaders();
			headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
			ClusterDto cluster = restTemplate.exchange(baseUrl + "/clusters/" + clusterId, HttpMethod.GET,
					new HttpEntity<String>("", headers), ClusterDto.class).getBody();
			cluster.setPushConfiguration(currentPushConfigurationDto);
			cluster.setGeolocEnabled(true);
			cluster.setHexa(true);
			cluster.setPushEnabled(true);
			headers.setContentType(MediaType.APPLICATION_JSON);
			ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/clusters/" + clusterId,
					HttpMethod.PATCH, new HttpEntity<ClusterDto>(cluster, headers), String.class);
		}
	}

	@Override
	public void removeRoutings() {
		this.getProperty("configId").ifPresent(configId -> {
			if (jwt == null || jwt.isExpired()) {
				login();
			}
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.exchange(baseUrl + "/pushConfigurations/" + configId, HttpMethod.DELETE,
					new HttpEntity<String>("", headers), String.class);
		});
	}

	@Override
	public void deprovisionDevice(String deveui) {
		if (jwt == null || jwt.isExpired()) {
			login();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
		headers.set("Accept", "application/json,application/vnd.kerlink.iot-v1+json");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(baseUrl + "/endDevices/" + deveui, HttpMethod.DELETE, new HttpEntity<String>("", headers),
				String.class);
	}

	public List<ClusterDto> getClusters() {
		List<ClusterDto> result = new ArrayList<ClusterDto>();
		if (jwt == null || jwt.isExpired()) {
			login();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
		RestTemplate restTemplate = new RestTemplate();
		PaginatedDto<ClusterDto> clusterDtos = restTemplate
				.exchange(baseUrl + "/clusters", HttpMethod.GET, new HttpEntity<String>("", headers),
						new ParameterizedTypeReference<PaginatedDto<ClusterDto>>() {
						})
				.getBody();
		for (ClusterDto clusterDto : clusterDtos.getList()) {
			result.add(clusterDto);
		}

		return result;
	}

	@Override
	public List<Gateway> getGateways() {
		List<Gateway> result = new ArrayList<>();
		if (jwt == null || jwt.isExpired()) {
			login();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", jwt.getTokenType() + " " + jwt.getToken());
		RestTemplate restTemplate = new RestTemplate();
		PaginatedDto<GatewayDto> gatewaysDto = restTemplate
				.exchange(baseUrl + "/gateways", HttpMethod.GET, new HttpEntity<String>("", headers),
						new ParameterizedTypeReference<PaginatedDto<GatewayDto>>() {
						})
				.getBody();
		C8YData c8yData = new C8YData();
		for (GatewayDto gatewayDto : gatewaysDto.getList()) {
			result.add(new Gateway(gatewayDto.getEui(), gatewayDto.getEui(), gatewayDto.getName(),
					gatewayDto.getLatitude(), gatewayDto.getLongitude(), gatewayDto.getDescription(),
					ConnectionState.AVAILABLE, c8yData, new HashMap<>()));
		}
		return result;
	}

	public void provisionGateway(lora.ns.gateway.GatewayProvisioning gatewayProvisioning) {
		// Not implemented
	}

	public void deprovisionGateway(String id) {
		// Not implemented
	}

	public boolean hasGatewayManagementCapability() {
		return false;
	}
}
