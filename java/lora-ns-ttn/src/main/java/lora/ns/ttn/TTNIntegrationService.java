package lora.ns.ttn;

import java.util.Base64;
import java.util.HashMap;

import org.apache.commons.codec.binary.Base16;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lora.ns.DeviceData;
import lora.ns.connector.LNSConnectorWizardStep;
import lora.ns.connector.PropertyDescription;
import lora.ns.integration.LNSIntegrationService;
import lora.ns.operation.OperationData;

@Service
public class TTNIntegrationService extends LNSIntegrationService<TTNConnector> {

	@Autowired
	private TTNUplinkProcessor uplinkProcessor;

	{
		wizard.add(LNSConnectorWizardStep.of("Initial step",
				PropertyDescription.text("address", "Address", true),
				PropertyDescription.text("apikey", "API Key", true).withEncrypted(true),
				PropertyDescription.bool("mqtt", "MQTT").withRequired(true)));
		wizard.add(LNSConnectorWizardStep.of("Application selection",
				PropertyDescription.list("appid", "Application", "/apps", true)));
		deviceProvisioningAdditionalProperties.add(PropertyDescription.list("MACVersion", "MAC Version", "/macversion", true));
		deviceProvisioningAdditionalProperties.add(PropertyDescription.list("PHYVersion", "PHY Version", "/phyversion", true));
		deviceProvisioningAdditionalProperties.add(PropertyDescription.list("frequencyPlan", "Frequency Plan", "/frequencyplan", true));

		gatewayProvisioningAdditionalProperties.add(PropertyDescription.bool("public", "Make status public").withRequired(true));
		gatewayProvisioningAdditionalProperties.add(PropertyDescription.list("frequencyPlan", "Frequency Plan", "/frequencyplan", true));
	}

	@Override
	public DeviceData processUplinkEvent(String event) {
		return uplinkProcessor.processUplinkEvent(event);
	}

	@Override
	public OperationData processDownlinkEvent(String event) {
		return uplinkProcessor.processDownlinkEvent(event);
	}

	@Override
	public boolean isOperationUpdate(String eventString) {
		return false;
	}

	@Override
	public String getType() {
		return "ttn";
	}

	@Override
	public String getName() {
		return "TTN (HTTP/MQTT)";
	}

	@Override
	public String getVersion() {
		return "1.1";
	}

	@Override
	public String getSimulatedPayload(java.util.Map<String, Object> fields) {
		if (fields.containsKey("payload")) {
			fields = new HashMap<>(fields);
			fields.put("payload",
					Base64.getEncoder().encodeToString(new Base16().decode(fields.get("payload").toString())));
		}
		return super.getSimulatedPayload(fields);
	}
}
