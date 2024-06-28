package lora.ns.actility;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import lora.ns.actility.common.RandomUtils;
import org.joda.time.DateTime;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cumulocity.microservice.subscription.service.MicroserviceSubscriptionsService;
import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import c8y.ConnectionState;
import feign.Client;
import feign.Feign;
import feign.Logger.Level;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import lora.codec.downlink.DownlinkData;
import lora.codec.uplink.C8YData;
import lora.ns.actility.rest.ActilityAdminService;
import lora.ns.actility.rest.ActilityCoreService;
import lora.ns.actility.rest.ActilityServiceAccountService;
import lora.ns.actility.rest.JwtInterceptor;
import lora.ns.actility.rest.model.BaseStation;
import lora.ns.actility.rest.model.BaseStationProfile;
import lora.ns.actility.rest.model.BaseStationStatistics.ConnectionStateEnum;
import lora.ns.actility.rest.model.BaseStationStatistics.HealthStateEnum;
import lora.ns.actility.rest.model.Connection;
import lora.ns.actility.rest.model.ConnectionHttpConfig;
import lora.ns.actility.rest.model.ConnectionRequest;
import lora.ns.actility.rest.model.DeviceCreate;
import lora.ns.actility.rest.model.DeviceProfile;
import lora.ns.actility.rest.model.DownlinkMessage;
import lora.ns.actility.rest.model.MessageSecurityParams;
import lora.ns.actility.rest.model.RFRegion;
import lora.ns.actility.rest.model.Route;
import lora.ns.actility.rest.model.Token;
import lora.ns.connector.LNSAbstractConnector;
import lora.ns.device.DeviceProvisioning;
import lora.ns.device.DeviceProvisioning.ProvisioningMode;
import lora.ns.device.EndDevice;
import lora.ns.exception.LoraException;
import lora.ns.gateway.Gateway;
import lora.ns.gateway.GatewayProvisioning;

@Slf4j
public class ActilityConnector extends LNSAbstractConnector {

	private static final String AS_ID_PROPERTY = "asId";
	private static final String AS_KEY_PROPERTY = "asKey";
	private static final String AS_ID_PREFIX = "cumulocity-";
	private static final String DEFAULT_AS_ID = "cumulocity";
	private static final String DEFAULT_AS_KEY = "4e0ff46472fa1840f25368c066e94769";

	private ActilityCoreService actilityCoreService;
	private ActilityAdminService actilityAdminService;
	private ActilityServiceAccountService actilityServiceAccountService;

	private String routeRef;

	private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JodaModule())
					.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
					.configure(SerializationFeature.INDENT_OUTPUT, true).setSerializationInclusion(Include.NON_NULL);

	class DXAdminJWTInterceptor extends JwtInterceptor {

		public DXAdminJWTInterceptor(String clientId, String clientSecret) {
			super(clientId, clientSecret);
		}

		@Override
		protected String getToken() {
			Token token = null;
			try {
				if (this.clientId.contains("/")) {
					token = actilityServiceAccountService.getToken("client_credentials", this.clientId,
									this.clientSecret);
				} else {
					token = actilityAdminService.getToken("client_credentials", this.clientId, this.clientSecret);
				}
			} catch (Exception e) {
				throw new LoraException("Couldn't get JWT", e);
			}
			if (token == null) {
				throw new LoraException("Couldn't get JWT");
			}
			log.info("Successfully received a JWT: {}", token);
			return token.getAccessToken();
		}
	}

	public ActilityConnector(Properties properties) {
		super(properties);
	}

	public ActilityConnector(ManagedObjectRepresentation instance) {
		super(instance);
	}

	// SSLSocketFactory
	// Install the all-trusting trust manager
	private static SSLSocketFactory getSSLSocketFactory() {
		try {
			SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, getTrustManager(), new SecureRandom());
			return sslContext.getSocketFactory();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// TrustManager
	// trust manager that does not validate certificate chains
	private static TrustManager[] getTrustManager() {
		return new TrustManager[] { new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) {
				// Do nothing, we trust everything
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) {
				// Do nothing, we trust everything
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[] {};
			}
		} };
	}

	// HostnameVerifier
	private static HostnameVerifier getHostnameVerifier() {
		return (String s, SSLSession sslSession) -> true;
	}

	@Override
	protected void init() {
		final ch.qos.logback.classic.Logger serviceLogger = (ch.qos.logback.classic.Logger) LoggerFactory
						.getLogger("lora.ns.actility");
		serviceLogger.setLevel(ch.qos.logback.classic.Level.DEBUG);
		var feignBuilder = Feign.builder().client(new Client.Default(getSSLSocketFactory(), getHostnameVerifier()))
						.decoder(new JacksonDecoder(objectMapper)).encoder(new FormEncoder())
						.logger(new Slf4jLogger("lora.ns.actility")).logLevel(Level.FULL)
						.requestInterceptor(template -> template.header("Content-Type",
										"application/x-www-form-urlencoded"));
		String url = properties.getProperty("url");
		actilityAdminService = feignBuilder.target(ActilityAdminService.class, url + "/thingpark/dx/admin/latest/api/");
		feignBuilder = Feign.builder().client(new Client.Default(getSSLSocketFactory(), getHostnameVerifier()))
						.decoder(new JacksonDecoder(objectMapper)).encoder(new FormEncoder())
						.logger(new Slf4jLogger("lora.ns.actility")).logLevel(Level.FULL)
						.requestInterceptor(template -> template.header("Content-Type",
										"application/x-www-form-urlencoded"));
		actilityServiceAccountService = feignBuilder.target(ActilityServiceAccountService.class,
						url + "/users-auth/protocol/");
		feignBuilder = Feign.builder().client(new Client.Default(getSSLSocketFactory(), getHostnameVerifier()))
						.decoder(new JacksonDecoder(objectMapper)).encoder(new JacksonEncoder(objectMapper))
						.logger(new Slf4jLogger("lora.ns.actility")).logLevel(Level.FULL)
						.requestInterceptor(template -> template.headers(Map.of("Content-Type",
										List.of("application/json"), "Accept", List.of("application/json"))));
		actilityCoreService = feignBuilder
						.requestInterceptor(new DXAdminJWTInterceptor(properties.getProperty("username"),
										properties.getProperty("password")))
						.target(ActilityCoreService.class, url + "/thingpark/dx/core/latest/api/");
	}

	@Override
	public List<EndDevice> getDevices() {
		return List.of();
	}

	@Override
	public EndDevice getDevice(String devEui) {
		var result = new EndDevice(devEui, devEui, "A");
		var devs = actilityCoreService.getDeviceByEUI(devEui);
		if (!devs.isEmpty()) {
			DeviceCreate dev = devs.get(0);
			log.info("Device {} is named {}", devEui, dev.getName());
			result = new EndDevice(devEui, dev.getName(), null);
		}
		return result;
	}

	@Override
	public String sendDownlink(DownlinkData operation) {
		log.info("Will send {} to Thingpark.", operation.toString());
		String correlationId = String.valueOf(DateTime.now().getMillis());
		DownlinkMessage message = new DownlinkMessage();
		message.setPayloadHex(operation.getPayload());
		message.setTargetPorts(operation.getFport().toString());
		MessageSecurityParams securityParams = new MessageSecurityParams();
		securityParams.setAsId(getAsId());
		securityParams.setAsKey(getAsKey());
		message.setSecurityParams(securityParams);
		message.setCorrelationID(correlationId);
		DownlinkMessage response = actilityCoreService.sendDownlink(operation.getDevEui(), message);
		return response.getCorrelationID();
	}

	@Override
	public void provisionDevice(DeviceProvisioning deviceProvisioning) {
		DeviceCreate device = new DeviceCreate();
		device.setEUI(deviceProvisioning.getDevEUI());
		device.setName(deviceProvisioning.getName());
		device.setProcessingStrategyId("ROUTE");
		device.getRouteRefs().add(routeRef);
		device.setDeviceProfileId(deviceProvisioning.getAdditionalProperties().getProperty("deviceProfile"));
		if (deviceProvisioning.getProvisioningMode() == ProvisioningMode.OTAA) {
			device.setActivationType("OTAA");
			device.setApplicationEUI(deviceProvisioning.getAppEUI());
			device.setApplicationKey(deviceProvisioning.getAppKey());
		} else {
			device.setActivationType("ABP");
		}

		actilityCoreService.createDevice(device);
	}

	@Override
	public void configureRoutings(String url, String tenant, String login, String password) {
		log.info("Configuring routings to: {} with credentials: {}:{}", url, login, password);
		String connectionId = null;

		for (Route route : actilityCoreService.getRoutes()) {
			if (route.getName().equals(tenant + "-" + getId())) {
				routeRef = route.getRef();
			}
		}
		for (Connection c : actilityCoreService.getConnections()) {
			if (c.getName().equals(tenant + "-" + getId())) {
				connectionId = c.getId();
			}
		}
		ConnectionRequest connectionRequest = new ConnectionRequest();
		ConnectionHttpConfig configuration = new ConnectionHttpConfig();
		configuration.setDestinationURL(url + "/uplink");
		configuration.getHeaders().put("Authorization", "Basic "
						+ Base64.getEncoder().encodeToString((tenant + "/" + login + ":" + password).getBytes()));
		configuration.setDownlinkAsId(getAsId());
		configuration.setDownlinkAsKey(getAsKey());
		connectionRequest.setConfiguration(configuration);
		connectionRequest.setName(tenant + "-" + this.getId());

		if (routeRef == null) {
			actilityCoreService.createConnection(connectionRequest);
			for (Route route : actilityCoreService.getRoutes()) {
				if (route.getName().equals(tenant + "-" + this.getId())) {
					routeRef = route.getRef();
				}
			}
		} else {
			actilityCoreService.updateConnection(connectionId, connectionRequest);
		}
		List<DeviceCreate> response = actilityCoreService.getDevices();
		response.forEach(d -> {
			if (!d.getRouteRefs().contains(routeRef)) {
				d.getRouteRefs().add(routeRef);
				try {
					actilityCoreService.updateDevice(d.getRef(), d);
				} catch (Exception e) {
					log.error("Couldn't update device", e);
				}
			}
		});
	}

	@Autowired
	private MicroserviceSubscriptionsService subscriptionsService;

	@Override
	public Optional<String> getCustomRoutingBaseUrl() {
		return isNotBlank(properties.getProperty("webhook-url")) ?
				Optional.of(properties.getProperty("webhook-url")) :
				super.getCustomRoutingBaseUrl();
	}

	@Override
	public void removeRoutings() {
		// Don't remove the connections, update them
	}

	@Override
	public void deprovisionDevice(String deveui) {
		var devs = actilityCoreService.getDeviceByEUI(deveui);
		if (!devs.isEmpty()) {
			actilityCoreService.deleteDevice(devs.get(0).getRef());
		}
	}

	@Override
	public List<Gateway> getGateways() {
		List<Gateway> result = new ArrayList<>();
		var baseStations = actilityCoreService.getBaseStations();
		for (BaseStation b : baseStations) {
			var baseStation = actilityCoreService.getBaseStation(b.getRef());
			Gateway g = new Gateway();
			g.setGwEUI(baseStation.getUuid());
			if (baseStation.getSMN() != null) {
				g.setSerial(baseStation.getSMN());
			}
			g.setName(baseStation.getName());
			if (baseStation.getGeoLatitude() != null) {
				g.setLat(BigDecimal.valueOf(baseStation.getGeoLatitude()));
			}
			if (baseStation.getGeoLongitude() != null) {
				g.setLng(BigDecimal.valueOf(baseStation.getGeoLongitude()));
			}
			if (baseStation.getStatistics() != null) {
				C8YData data = new C8YData();
				if (baseStation.getStatistics().getConnectionState() == ConnectionStateEnum.CNX
								&& baseStation.getStatistics().getHealthState() == HealthStateEnum.ACTIVE) {
					g.setStatus(ConnectionState.AVAILABLE);
				} else {
					g.setStatus(ConnectionState.UNAVAILABLE);
				}
				if (baseStation.getStatistics().getTemperature() != null) {
					data.addMeasurement(null, "Temperature", "T", "°C",
									BigDecimal.valueOf(baseStation.getStatistics().getTemperature()), new DateTime());
				}
				if (baseStation.getStatistics().getCpUUsage() != null) {
					data.addMeasurement(null, "CPU", "Usage", "%",
									BigDecimal.valueOf(baseStation.getStatistics().getCpUUsage()), new DateTime());
				}
				if (baseStation.getStatistics().getRaMUsage() != null) {
					data.addMeasurement(null, "RAM", "Usage", "%",
									BigDecimal.valueOf(baseStation.getStatistics().getRaMUsage()), new DateTime());
				}
				if (baseStation.getStatistics().getBatteryLevel() != null) {
					data.addMeasurement(null, "Battery", "level", "%",
									BigDecimal.valueOf(baseStation.getStatistics().getBatteryLevel()), new DateTime());
				}
				g.setData(data);
			}
			result.add(g);
		}

		return result;
	}

	public List<DeviceProfile> getDeviceProfiles() {
		return actilityCoreService.getDeviceProfiles();
	}

	public void provisionGateway(GatewayProvisioning gatewayProvisioning) {
		BaseStation baseStation = new BaseStation();
		baseStation.setName(gatewayProvisioning.getName());
		baseStation.setUuid(gatewayProvisioning.getGwEUI());
		baseStation.setSMN(gatewayProvisioning.getAdditionalProperties().getProperty("SMN"));
		baseStation.setPublicKey(gatewayProvisioning.getAdditionalProperties().getProperty("publicKey"));
		if (gatewayProvisioning.getLat() != null) {
			baseStation.setGeoLatitude(gatewayProvisioning.getLat().floatValue());
		}
		if (gatewayProvisioning.getLng() != null) {
			baseStation.setGeoLongitude(gatewayProvisioning.getLng().floatValue());
		}
		baseStation.setBaseStationProfileId(
						gatewayProvisioning.getAdditionalProperties().getProperty("gatewayProfile"));
		baseStation.setRfRegionId(gatewayProvisioning.getAdditionalProperties().getProperty("rfRegion"));
		actilityCoreService.createBaseStation(baseStation);
	}

	public void deprovisionGateway(String id) {
		actilityCoreService.deleteBaseStation(id);
	}

	@Override
	public Properties getInitProperties() {
		Properties initProperties = super.getInitProperties();
		initProperties.put(AS_ID_PROPERTY, AS_ID_PREFIX + RandomUtils.generateRandomHexString(16));
		initProperties.put(AS_KEY_PROPERTY, RandomUtils.generateRandomHexString(32));
		return initProperties;
	}

	public List<BaseStationProfile> getBaseStationProfiles() {
		return actilityCoreService.getBaseStationProfiles();
	}

	public List<RFRegion> getRFRegions() {
		return actilityCoreService.getRFRegions();
	}

	public boolean hasGatewayManagementCapability() {
		return true;
	}

	private String getAsId() {
		return getProperty(AS_ID_PROPERTY)
				.map(Object::toString)
				.orElse(DEFAULT_AS_ID);
	}

	private String getAsKey() {
		return getProperty(AS_KEY_PROPERTY)
				.map(Object::toString)
				.orElse(DEFAULT_AS_KEY);
	}
}
