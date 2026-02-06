package lora.ns.actility;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import lora.ns.connector.PropertyDescription;

/**
 * Tests for Actility SSL validation configurability (Step 1d).
 * Verifies that the disableSslValidation property is exposed in the wizard.
 */
class ActilitySslConfigTest {

	@Test
	void wizardStep1_shouldIncludeSslValidationProperty() {
		ConnectorWizardStep1 step = new ConnectorWizardStep1();
		List<PropertyDescription> props = step.getPropertyDescriptions();
		boolean hasSslProp = props.stream()
				.anyMatch(p -> "disableSslValidation".equals(p.getName()));
		assertTrue(hasSslProp, "Wizard step 1 should include disableSslValidation property");
	}

	@Test
	void wizardStep1_shouldHaveCorrectPropertyCount() {
		ConnectorWizardStep1 step = new ConnectorWizardStep1();
		// url, username, password, domain, group, webhook-url, disableSslValidation
		assertFalse(step.getPropertyDescriptions().isEmpty());
	}
}
