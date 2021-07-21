package lora.rest;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lora.ns.connector.LNSConnector;
import lora.ns.connector.LNSConnectorRepresentation;
import lora.ns.connector.LNSConnectorWizardStep;
import lora.ns.connector.PropertyDescription;
import lora.ns.device.DeviceProvisioning;
import lora.ns.device.DeviceProvisioningResponse;
import lora.ns.device.EndDevice;
import lora.ns.device.LNSDeviceManager;
import lora.ns.integration.LNSIntegrationService;

@RestController
public class LNSRestController {

	@Autowired
	private LNSIntegrationService<?> lnsProxy;

	@Autowired
	private LNSDeviceManager lnsDeviceManager;

	final Logger logger = LoggerFactory.getLogger(LNSRestController.class);

	@PostMapping(value = "/{lnsInstanceId}/uplink", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> lnsUp(@RequestBody String event, @PathVariable String lnsInstanceId,
			HttpServletRequest request) {
		logger.info("Event received from {}: {}", request.getRemoteAddr(), event);
		lnsProxy.mapEventToC8Y(event, lnsInstanceId);
		return ResponseEntity.ok().build();
	}

	@PostMapping(value = "/{lnsInstanceId}/downlink", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> lnsDown(@RequestBody String event, @PathVariable String lnsInstanceId,
			HttpServletRequest request) {
		logger.info("Event received from {}: {}", request.getRemoteAddr(), event);
		lnsProxy.updateOperation(event, lnsInstanceId);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/{lnsInstanceId}/devices", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EndDevice> getDevices(@PathVariable String lnsInstanceId) {
		return lnsProxy.getDevices(lnsInstanceId);
	}
	
	@PostMapping(value = "/{lnsInstanceId}/devices", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DeviceProvisioningResponse provisionDevice(@RequestBody DeviceProvisioning deviceProvisioning, @PathVariable String lnsInstanceId) {
		return lnsProxy.provisionDevice(lnsInstanceId, deviceProvisioning);
	}
	
	@DeleteMapping(value = "/{lnsInstanceId}/devices/{deveui}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deprovisionDevice(@PathVariable String lnsInstanceId, @PathVariable String deveui) {
		boolean result = lnsProxy.deprovisionDevice(lnsInstanceId, deveui);
		return result ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
	}

	@PostMapping(value = "/devices/{deveui}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createDevice(@PathVariable String deveui, @RequestBody ManagedObjectRepresentation device) {
		lnsDeviceManager.createDevice(deveui, device);
		return ResponseEntity.ok().build();
	}

	@PutMapping(value = "/devices/{deveui}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateDevice(@PathVariable String deveui, @RequestBody ManagedObjectRepresentation device) {
		lnsDeviceManager.updateDevice(deveui, device);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/lnsinstances", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, LNSConnector> getLnsInstances() {
		return lnsProxy.getConnectors();
	}
	
	@PostMapping(value = "/lnsinstances", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ManagedObjectRepresentation addLnsInstance(@RequestBody LNSConnectorRepresentation instance) {
		return lnsProxy.addLNSInstance(instance);
	}
	
	@DeleteMapping(value = "/lnsinstances/{lnsInstanceId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeLnsInstance(@PathVariable String lnsInstanceId) {
		lnsProxy.removeLNSInstance(lnsInstanceId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/wizard", produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedList<LNSConnectorWizardStep> getWizard() {
		return lnsProxy.getInstanceWizard();
	}
	
	@GetMapping(value = "/deviceProvisioningAdditionalProperties", produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedList<PropertyDescription> getDeviceProvisioningAdditionalProperties() {
		return lnsProxy.getDeviceProvisioningAdditionalProperties();
	}
}
