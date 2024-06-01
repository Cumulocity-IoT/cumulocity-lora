package lora.ns.liveobjects;

import java.util.List;
import lora.ns.connector.LNSConnectorWizardStep;
import lora.ns.connector.PropertyDescription;

class ConnectorWizardStep1 implements LNSConnectorWizardStep {

    private final List<PropertyDescription> propertyDescriptions = List.of(
            PropertyDescription.text("apikey", "API Key", true).withEncrypted(true),
            PropertyDescription.text("proxy-host", "Proxy Host", false),
            PropertyDescription.number("proxy-port", "Proxy Port", false));

    public String getName() {
        return "step1";
    }

    public List<PropertyDescription> getPropertyDescriptions() {
        return propertyDescriptions;
    }
}
