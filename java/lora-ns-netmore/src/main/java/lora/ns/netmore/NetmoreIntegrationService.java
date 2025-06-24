package lora.ns.netmore;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.cumulocity.model.measurement.MeasurementValue;
import com.cumulocity.rest.representation.measurement.MeasurementRepresentation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.BaseEncoding;

import lombok.extern.slf4j.Slf4j;
import lora.ns.DeviceData;
import lora.ns.connector.LNSConnectorWizardStep;
import lora.ns.connector.PropertyDescription;
import lora.ns.integration.LNSIntegrationService;
import lora.ns.operation.OperationData;

@Service
@Slf4j
public class NetmoreIntegrationService extends LNSIntegrationService<NetmoreConnector> {

    {
        wizard.add(new LNSConnectorWizardStep() {

            private final List<PropertyDescription> propertyDescriptions = List.of(
                PropertyDescription.password("apiKey", "API Key"),
                PropertyDescription.text("customerId", "Customer ID", true)
            );
    
            @Override
            public String getName() {
                return "step 1";
            }

            @Override
            public List<PropertyDescription> getPropertyDescriptions() {
                return propertyDescriptions;
            }
        });

        deviceProvisioningAdditionalProperties.add(PropertyDescription.list("deviceGroupId", "Device Group", "/deviceGroups", true));
        gatewayProvisioningAdditionalProperties.add(PropertyDescription.list("gatewayGroupId", "Gateway Group", "/gatewayGroups", true));
        gatewayProvisioningAdditionalProperties.add(PropertyDescription.list("gatewayTypeId", "Gateway Type", "/gatewayTypes", true));
    }

    @Override
    public String getType() {
        return "netmore";
    }

    @Override
    public String getName() {
        return "Netmore";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public DeviceData processUplinkEvent(String event) throws IOException {
        if (event.equals("{}")) {
            log.info("Received empty event");
            return null;
        }
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode;
		rootNode = mapper.readTree(event);
		String devEUI = rootNode.at("/devEUI").asText();
		if (devEUI == null) {
			throw new InvalidParameterException("DevEUI can't be null");
		}
		int fPort = rootNode.at("/fPort").asInt();
		JsonNode payloadNode = rootNode.at("/payload");
		byte[] payload = new byte[0];
		if (payloadNode != null && !payloadNode.isNull()) {
			payload = BaseEncoding.base16().decode(payloadNode.asText().toUpperCase());
		}
		Long updateTime = new DateTime(rootNode.at("/timestamp").asText()).getMillis();
		loraContextService.log("Update time is: {}", updateTime);

		double rssi = rootNode.at("/rssi").asDouble();
		double snr = rootNode.at("/snr").asDouble();
		double sf = rootNode.at("/spreadingFactor").asDouble();

		List<MeasurementRepresentation> measurements = new ArrayList<>();
		MeasurementRepresentation m = new MeasurementRepresentation();
		Map<String, MeasurementValue> measurementValueMap = new HashMap<>();

		MeasurementValue mv = new MeasurementValue();
		mv.setValue(BigDecimal.valueOf(rssi));
		mv.setUnit("dBm");
		measurementValueMap.put("rssi", mv);

		mv = new MeasurementValue();
		mv.setValue(BigDecimal.valueOf(snr));
		mv.setUnit("dB");
		measurementValueMap.put("snr", mv);

		mv = new MeasurementValue();
		mv.setValue(BigDecimal.valueOf(sf));
		mv.setUnit("");
		measurementValueMap.put("sf", mv);

		m.set(measurementValueMap, "c8y_SignalStrength");
		m.setType("c8y_SignalStrength");
		m.setDateTime(new DateTime(updateTime));
		measurements.add(m);

		return new DeviceData(devEUI, devEUI, null, null, fPort, payload, updateTime, measurements, null, null);
    }

    @Override
    public OperationData processDownlinkEvent(String eventString) throws IOException {
        log.info("Received {} but don't know yet what to do with it...", eventString);
        return new OperationData();
    }

    @Override
    public boolean isOperationUpdate(String eventString) {
        return false;
    }
}
