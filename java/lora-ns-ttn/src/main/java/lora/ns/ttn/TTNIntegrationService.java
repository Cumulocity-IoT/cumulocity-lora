package lora.ns.ttn;

import java.util.Base64;
import java.util.HashMap;

import org.apache.commons.codec.binary.Base16;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lora.ns.DeviceData;
import lora.ns.connector.PropertyDescription;
import lora.ns.connector.PropertyDescription.PropertyType;
import lora.ns.integration.LNSIntegrationService;
import lora.ns.operation.OperationData;

@Service
public class TTNIntegrationService extends LNSIntegrationService<TTNConnector> {

	@Autowired
	private TTNUplinkProcessor uplinkProcessor;

	{
		wizard.add(new InstanceWizardStep1());
		wizard.add(new InstanceWizardStep2());
		deviceProvisioningAdditionalProperties.add(new PropertyDescription("MACVersion", "MAC Version", true, null,
				"/macversion", null, null, null, null, null, PropertyType.LIST, false));
		deviceProvisioningAdditionalProperties.add(new PropertyDescription("PHYVersion", "PHY Version", true, null,
				"/phyversion", null, null, null, null, null, PropertyType.LIST, false));
		deviceProvisioningAdditionalProperties.add(new PropertyDescription("frequencyPlan", "Frequency Plan", true,
				null, "/frequencyplan", null, null, null, null, null, PropertyType.LIST, false));

		gatewayProvisioningAdditionalProperties.add(new PropertyDescription("public", "Make status public", true, null,
				null, null, null, null, null, null, PropertyType.BOOLEAN, false));
		gatewayProvisioningAdditionalProperties.add(new PropertyDescription("frequencyPlan", "Frequency Plan", true,
				null, "/frequencyplan", null, null, null, null, null, PropertyType.LIST, false));
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
