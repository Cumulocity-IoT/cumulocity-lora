package lora.ns.actility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cumulocity.model.measurement.MeasurementValue;
import com.cumulocity.model.operation.OperationStatus;
import com.cumulocity.rest.representation.measurement.MeasurementRepresentation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.BaseEncoding;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lora.ns.DeviceData;
import lora.ns.integration.LNSIntegrationService;
import lora.ns.operation.OperationData;

@Service
public class ActilityIntegrationService extends LNSIntegrationService<ActilityConnector> {
	
	private final Logger logger = LoggerFactory.getLogger(ActilityIntegrationService.class);
	
	{
		wizard.add(new ConnectorWizardStep1());
	}

	@Override
	public DeviceData processUplinkEvent(String event) {
        ObjectMapper mapper = new ObjectMapper();
        DeviceData data = null;
        try {
            JsonNode rootNode = mapper.readTree(event);
            String deviceEui = rootNode.get("device_properties").get("deveui").asText();
            String name = rootNode.get("device_properties").get("external_id").asText();
            int fPort = rootNode.get("protocol_data").get("port").asInt();
            double rssi = rootNode.get("protocol_data").get("rssi").asDouble();
            double snr = rootNode.get("protocol_data").get("snr").asDouble();
            double noise = rootNode.get("protocol_data").get("noise").asDouble();
            double signal = rootNode.get("protocol_data").get("signal").asDouble();
            double sf = rootNode.get("protocol_data").get("sf").asDouble();
            Double lat = rootNode.has("lat") ? rootNode.get("lat").asDouble() : null;
            Double lng = rootNode.has("lng") ? rootNode.get("lng").asDouble() : null;
            logger.info("Signal strength: rssi = {} dBm, snr = {} dB", rssi, snr);
            byte[] payload = BaseEncoding.base16().decode(rootNode.get("payload_cleartext").asText().toUpperCase());
            Long updateTime = new DateTime(rootNode.get("timestamp").asText()).getMillis();
            //String model = null;
            logger.info("Update time is: " + updateTime);

            List<MeasurementRepresentation> measurements = new ArrayList<>();
    		MeasurementRepresentation m = new MeasurementRepresentation();
    		Map<String, MeasurementValue> measurementValueMap = new HashMap<>();
    		
    		MeasurementValue mv = new MeasurementValue();
    		mv.setValue(BigDecimal.valueOf(rssi));
    		mv.setUnit("dBm");
    		measurementValueMap.put("rssi", mv);
    		
    		mv = new MeasurementValue();
    		mv.setValue(BigDecimal.valueOf(noise));
    		mv.setUnit("dBm");
    		measurementValueMap.put("noise", mv);
    		
    		mv = new MeasurementValue();
    		mv.setValue(BigDecimal.valueOf(signal));
    		mv.setUnit("dBm");
    		measurementValueMap.put("signal", mv);

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

    		data = new DeviceData(name, deviceEui, null, null, fPort, payload, updateTime, measurements, lat != null ? BigDecimal.valueOf(lat) : null, lng != null ? BigDecimal.valueOf(lng) : null);
        } catch (Exception e) {
        	e.printStackTrace();
            logger.error("Error on Mapping LoRa payload to Cumulocity", e);
        }
		return data;
	}

	@Override
	public OperationData processDownlinkEvent(String event) {
		OperationData data = new OperationData();
		data.setStatus(OperationStatus.SUCCESSFUL);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(event);
            String commandId = rootNode.get("command_id") != null ? rootNode.get("command_id").asText() : null;
            if (commandId != null) {
            	data.setCommandId(commandId);
	            JsonNode error = rootNode.get("error");
	            if (error != null) {
	            	data.setErrorMessage(error.asText());
	            	data.setStatus(OperationStatus.FAILED);
	            }
            }
        } catch (Exception e) {
            logger.error("Error on Mapping LoRa payload to Cumulocity", e);
        }
		return data;
	}
	
	@Override
	public boolean isOperationUpdate(String eventString) {
		return false;
	}

	@Override
	public String getType() {
		return "actility";
	}

	@Override
	public String getName() {
		return "Actility Thingpark (push mode)";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}
}
