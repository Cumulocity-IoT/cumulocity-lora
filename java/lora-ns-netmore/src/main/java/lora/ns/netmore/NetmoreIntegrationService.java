package lora.ns.netmore;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import lora.ns.DeviceData;
import lora.ns.connector.LNSConnectorWizardStep;
import lora.ns.connector.PropertyDescription;
import lora.ns.integration.LNSIntegrationService;
import lora.ns.operation.OperationData;

@Service
public class NetmoreIntegrationService extends LNSIntegrationService<NetmoreConnector> {

    {
        wizard.add(new LNSConnectorWizardStep() {

            private final List<PropertyDescription> propertyDescriptions = List.of(
                PropertyDescription.text("apiKey", "API Key", true).withEncrypted(true),
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
    public DeviceData processUplinkEvent(String eventString) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processUplinkEvent'");
    }

    @Override
    public OperationData processDownlinkEvent(String eventString) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processDownlinkEvent'");
    }

    @Override
    public boolean isOperationUpdate(String eventString) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOperationUpdate'");
    }
}
