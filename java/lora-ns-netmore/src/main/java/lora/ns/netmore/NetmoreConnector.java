package lora.ns.netmore;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import c8y.ConnectionState;
import feign.Feign;
import feign.FeignException.FeignClientException;
import feign.Logger.Level;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lora.codec.downlink.DownlinkData;
import lora.ns.connector.LNSAbstractConnector;
import lora.ns.device.DeviceProvisioning;
import lora.ns.device.EndDevice;
import lora.ns.gateway.Gateway;
import lora.ns.gateway.GatewayProvisioning;
import lora.ns.netmore.rest.DeviceGroupsApi;
import lora.ns.netmore.rest.DevicesApi;
import lora.ns.netmore.rest.ExportConfigGroupsApi;
import lora.ns.netmore.rest.ExportConfigsApi;
import lora.ns.netmore.rest.GatewayGroupsApi;
import lora.ns.netmore.rest.GatewayTypesApi;
import lora.ns.netmore.rest.GatewaysApi;
import lora.ns.netmore.rest.LoRaWanDevicesApi;
import lora.ns.netmore.rest.LoRaWanGatewaysApi;
import lora.ns.netmore.rest.model.ActivationMethod;
import lora.ns.netmore.rest.model.CreateDeviceRequest;
import lora.ns.netmore.rest.model.CreateExportConfigGroupRequest;
import lora.ns.netmore.rest.model.CreateExportConfigRequest;
import lora.ns.netmore.rest.model.CreateExportConfigRequest.ExportTypeEnum;
import lora.ns.netmore.rest.model.CreateGatewayRequest;
import lora.ns.netmore.rest.model.CreateLoraDevice;
import lora.ns.netmore.rest.model.CreateLoraGateway;
import lora.ns.netmore.rest.model.Device;
import lora.ns.netmore.rest.model.DeviceGroup;
import lora.ns.netmore.rest.model.ExportConfig;
import lora.ns.netmore.rest.model.ExportConfigGroup;
import lora.ns.netmore.rest.model.ExportConfigType;
import lora.ns.netmore.rest.model.ExportMessageFormats;
import lora.ns.netmore.rest.model.GatewayGroup;
import lora.ns.netmore.rest.model.GatewayType;
import lora.ns.netmore.rest.model.HttpPushExportConfigHeadersInner;
import lora.ns.netmore.rest.model.LoraVersion;
import lora.ns.netmore.rest.model.ModelClass;
import lora.ns.netmore.rest.model.PatchDeviceRequest;
import lora.ns.netmore.rest.model.PatchGatewayRequest;
import lora.ns.netmore.rest.model.UpdateExportConfigGroupRequest;
import lora.ns.netmore.rest.model.UpdateExportConfigRequest;

public class NetmoreConnector extends LNSAbstractConnector {

    private DeviceGroupsApi deviceGroupsApi;
    private DevicesApi devicesApi;
    private GatewayGroupsApi gatewayGroupsApi;
    private GatewaysApi gatewaysApi;
    private GatewayTypesApi gatewayTypesApi;
    private LoRaWanDevicesApi loRaWanDevicesApi;
    private LoRaWanGatewaysApi loRaWanGatewaysApi;
    private ExportConfigsApi exportConfigsApi;
    private ExportConfigGroupsApi exportConfigGroupsApi;

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JodaModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.INDENT_OUTPUT, true)
            .setSerializationInclusion(Include.NON_NULL);

    public NetmoreConnector(Properties properties) {
        super(properties);
    }

    public NetmoreConnector(ManagedObjectRepresentation instance) {
        super(instance);
    }

    @Override
    protected void init() {
        final ch.qos.logback.classic.Logger serviceLogger = (ch.qos.logback.classic.Logger) LoggerFactory
                .getLogger("lora.ns.netmore");
        serviceLogger.setLevel(ch.qos.logback.classic.Level.DEBUG);

        String apiKey = properties.getProperty("apiKey");
        String baseUrl = "https://api.connect.netmoregroup.com/api/v1";

        var feignBuilder = Feign.builder()
                .client(new OkHttpClient())
                .decoder(new JacksonDecoder(objectMapper))
                .encoder(new JacksonEncoder(objectMapper))
                .logger(new Slf4jLogger("lora.ns.netmore"))
                .logLevel(Level.FULL)
                .requestInterceptor(template -> template.header("api-key", apiKey));

        deviceGroupsApi = feignBuilder.target(DeviceGroupsApi.class, baseUrl);
        devicesApi = feignBuilder.target(DevicesApi.class, baseUrl);
        exportConfigsApi = feignBuilder.target(ExportConfigsApi.class, baseUrl);
        gatewayGroupsApi = feignBuilder.target(GatewayGroupsApi.class, baseUrl);
        gatewayTypesApi = feignBuilder.target(GatewayTypesApi.class, baseUrl);
        gatewaysApi = feignBuilder.target(GatewaysApi.class, baseUrl);
        loRaWanDevicesApi = feignBuilder.target(LoRaWanDevicesApi.class, baseUrl);
        loRaWanGatewaysApi = feignBuilder.target(LoRaWanGatewaysApi.class, baseUrl);
        exportConfigGroupsApi = feignBuilder.target(ExportConfigGroupsApi.class, baseUrl);
    }

    @Override
    public List<EndDevice> getDevices() {
        return new ArrayList<>();
    }

    @Override
    public EndDevice getDevice(String devEui) {
        Device device = loRaWanDevicesApi.getLoraDeviceData(devEui, false, null);
        return new EndDevice(devEui, device.getName(), devEui);
    }

    @Override
    public String sendDownlink(DownlinkData operation) {
        Double id = loRaWanDevicesApi.sendDownlinkLoRaWAN(operation.getDevEui(), operation.getPayload(),
                operation.getFport().doubleValue(), true, 0.0);
        return id.toString();
    }

    @Override
    public void provisionDevice(DeviceProvisioning deviceProvisioning) {
        getProperty("exportConfigGroupId").ifPresentOrElse(o -> {
            String customerId = getProperty("customerId").get().toString();
            String deviceGroupId = deviceProvisioning.getAdditionalProperties().get("deviceGroupId").toString();
            CreateDeviceRequest createDeviceRequest = new CreateDeviceRequest()
                    .loraDevice(new CreateLoraDevice()
                            .devEui(deviceProvisioning.getDevEUI())
                            .appKey(deviceProvisioning.getAppKey())
                            .appEui(deviceProvisioning.getAppEUI())
                            .propertyClass(ModelClass.fromValue(deviceProvisioning.getDeviceClass().name()))
                            .loraVersion(LoraVersion.V100)
                            .activationMethod(ActivationMethod.OTAA))
                    .name(deviceProvisioning.getName())
                    .exportConfigGroupId(getProperty("exportConfigGroupId").get().toString());

            devicesApi.createDevice(customerId, deviceGroupId, createDeviceRequest);
        }, () -> {
            throw new InvalidParameterException("Export config group id is not set");
        });
    }

    @Override
    public void configureRoutings(String url, String tenant, String login, String password) {
        String customerId = getProperty("customerId").get().toString();

        updateOrCreateExportConfig(url, tenant, login, password, customerId, "uplink");

        updateOrCreateExportConfig(url, tenant, login, password, customerId, "downlink");

        getProperty("exportConfigGroupId").ifPresentOrElse(o -> {
            try {
                exportConfigGroupsApi.getExportConfigGroup(customerId, o.toString());
                exportConfigGroupsApi.updateExportConfigGroup(customerId, o.toString(),
                        new UpdateExportConfigGroupRequest()
                                .addExportConfigsItem(getProperty("uplinkExportConfigId").get().toString())
                                .addExportConfigsItem(getProperty("downlinkExportConfigId").get().toString()));
            } catch (FeignClientException e) {
                if (e.status() == 404) {
                    createExportConfigGroup(tenant, customerId);
                } else {
                    throw e;
                }
            }
        }, () -> {
            createExportConfigGroup(tenant, customerId);
        });
    }

    private void updateOrCreateExportConfig(String url, String tenant, String login, String password, String customerId, String type) {
        getProperty(type + "ExportConfigId").ifPresentOrElse(o -> {
            try {
                ExportConfig exportConfig = exportConfigsApi.getExportConfig(customerId, o.toString());
                ExportConfigType exportConfigType = new ExportConfigType()
                        .url(url + "/" + type)
                        .headers(List.of(new HttpPushExportConfigHeadersInner()
                                .name("Authorization")
                                .value("Basic "
                                        + Base64.getEncoder().encodeToString((tenant + "/" + login + ":" + password).getBytes()))));
                exportConfigsApi.updateExportConfig(customerId, exportConfig.getExportConfigId(),
                        new UpdateExportConfigRequest().config(exportConfigType).exportType(UpdateExportConfigRequest.ExportTypeEnum.HTTP_PUSH));
            } catch (FeignClientException e) {
                if (e.status() == 404) {
                    createExportConfig(url, tenant, login, password, customerId, type);
                } else {
                    throw e;
                }
            }
        }, () -> {
            createExportConfig(url, tenant, login, password, customerId, type);
        });
    }

    private void createExportConfigGroup(String tenant, String customerId) {
        ExportConfigGroup group = exportConfigGroupsApi.createExportConfigGroup(customerId,
                new CreateExportConfigGroupRequest().name("Cumulocity " + tenant)
                        .addExportConfigsItem(getProperty("uplinkExportConfigId").get().toString())
                        .addExportConfigsItem(getProperty("downlinkExportConfigId").get().toString()));

        setProperty("exportConfigGroupId", group.getExportConfigGroupId());
    }

    private void createExportConfig(String url, String tenant, String login, String password, String customerId,
            String type) {
        ExportConfig exportConfig = exportConfigsApi.createExportConfig(customerId, new CreateExportConfigRequest()
                .name("Cumulocity " + tenant + " " + type)
                .exportType(ExportTypeEnum.HTTP_PUSH)
                .formatCode("DEFAULT_MQ_ALL")
                .messageFormats(new ExportMessageFormats().uplink(true))
                .activeOnCustomer(true)
                .config(new ExportConfigType()
                        .url(url + "/" + type)
                        .headers(List.of(new HttpPushExportConfigHeadersInner()
                                .name("Authorization")
                                .value("Basic " + Base64.getEncoder()
                                        .encodeToString((tenant + "/" + login + ":" + password).getBytes()))))));
        setProperty(type + "ExportConfigId", exportConfig.getExportConfigId());
    }

    @Override
    public void removeRoutings() {
    }

    @Override
    public void deprovisionDevice(String devEui) {
        loRaWanDevicesApi.patchDeviceLoRaWAN(devEui, new PatchDeviceRequest().deleted(true));
    }

    @Override
    public List<Gateway> getGateways() {
        String customerId = getProperty("customerId").get().toString();
        return gatewaysApi.getAllByCustomer(customerId).stream().filter(gateway -> gateway.getLoraGateway() != null)
                .map(gateway -> new Gateway(gateway.getLoraGwEui(),
                        loRaWanGatewaysApi.getLoraGateway(gateway.getLoraGwEui()).getSerialNumber(), gateway.getName(),
                        BigDecimal.valueOf(gateway.getLocation().getLatitude()),
                        BigDecimal.valueOf(gateway.getLocation().getLongitude()), gateway.getGatewayTypeId(),
                        gateway.getLoraGateway().getActive() ? ConnectionState.AVAILABLE : ConnectionState.UNAVAILABLE,
                        null, null))
                .collect(Collectors.toList());
    }

    @Override
    public void provisionGateway(GatewayProvisioning gatewayProvisioning) {
        String customerId = getProperty("customerId").get().toString();
        String gatewayGroupId = gatewayProvisioning.getAdditionalProperties().get("gatewayGroupId").toString();
        String gatewayTypeId = gatewayProvisioning.getAdditionalProperties().get("gatewayTypeId").toString();
        CreateGatewayRequest createGatewayRequest = new CreateGatewayRequest()
                .loraGateway(new CreateLoraGateway()
                        .gwEui(gatewayProvisioning.getGwEUI()))
                .gatewayTypeId(gatewayTypeId)
                .serialNumber(gatewayProvisioning.getSerial())
                .name(gatewayProvisioning.getName());

        gatewaysApi.createGateway(customerId, gatewayGroupId, createGatewayRequest);
    }

    @Override
    public void deprovisionGateway(String id) {
        loRaWanGatewaysApi.patchGatewayLoraWan(id, new PatchGatewayRequest().deleted(true));
    }

    @Override
    public boolean hasGatewayManagementCapability() {
        return true;
    }

    public List<DeviceGroup> getDeviceGroups() {
        String customerId = getProperty("customerId").get().toString();
        return deviceGroupsApi.getDeviceGroups(customerId);
    }

    public List<GatewayGroup> getGatewayGroups() {
        String customerId = getProperty("customerId").get().toString();
        return gatewayGroupsApi.getGatewayGroups(customerId);
    }

    public List<GatewayType> getGatewayTypes() {
        return gatewayTypesApi.getGatewayTypes();
    }
}