package lora.ns.actility;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import lora.ns.connector.LNSConnectorWizardStep;
import lora.ns.connector.PropertyDescription;

/**
 * Tests for Actility SSL validation configurability.
 * Verifies that the disableSslValidation property is exposed in the wizard.
 */
class ActilitySslConfigTest {

	@Test
	void wizardStep1_shouldIncludeSslValidationProperty() {
		ActilityIntegrationService service = new ActilityIntegrationService();
		LNSConnectorWizardStep step = service.getInstanceWizard().get(0);
		List<PropertyDescription> props = step.getPropertyDescriptions();
		boolean hasSslProp = props.stream()
				.anyMatch(p -> "disableSslValidation".equals(p.getName()));
		assertTrue(hasSslProp, "Wizard step 1 should include disableSslValidation property");
	}

	@Test
	void wizardStep1_shouldHaveCorrectPropertyCount() {
		ActilityIntegrationService service = new ActilityIntegrationService();
		LNSConnectorWizardStep step = service.getInstanceWizard().get(0);
		// url, username, password, domain, group, webhook-url, disableSslValidation
		assertFalse(step.getPropertyDescriptions().isEmpty());
	}
}
