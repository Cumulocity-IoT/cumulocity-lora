package lora.ns.connector;

import java.util.List;

public interface LNSConnectorWizardStep {
	String getName();
	List<PropertyDescription> getPropertyDescriptions();

	static LNSConnectorWizardStep of(String name, PropertyDescription... properties) {
		List<PropertyDescription> props = List.of(properties);
		return new LNSConnectorWizardStep() {
			@Override
			public String getName() {
				return name;
			}

			@Override
			public List<PropertyDescription> getPropertyDescriptions() {
				return props;
			}
		};
	}
}
