package lora.rest;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;

import lora.ns.DeviceProvisioning;
import lora.ns.EndDevice;
import lora.ns.LNSInstance;
import lora.ns.LNSInstanceRepresentation;
import lora.ns.LNSInstanceWizardStep;
import lora.ns.LNSProxy;

@RestController
public class LNSRestController {

	@Autowired
	private LNSProxy lnsProxy;

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
	public ManagedObjectRepresentation provisionDevice(@RequestBody DeviceProvisioning deviceProvisioning, @PathVariable String lnsInstanceId) {
		return lnsProxy.provisionDevice(lnsInstanceId, deviceProvisioning);
	}
	
	@DeleteMapping(value = "/{lnsInstanceId}/devices/{deveui}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deprovisionDevice(@PathVariable String lnsInstanceId, @PathVariable String deveui) {
		boolean result = lnsProxy.deprovisionDevice(lnsInstanceId, deveui);
		return result ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
	}
	
	@GetMapping(value = "/lnsinstances", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Map<String, LNSInstance>> getLnsInstances() {
		return lnsProxy.getInstances();
	}
	
	@PostMapping(value = "/lnsinstances", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ManagedObjectRepresentation addLnsInstance(@RequestBody LNSInstanceRepresentation instance) {
		return lnsProxy.addLNSInstance(instance);
	}
	
	@DeleteMapping(value = "/lnsinstances/{lnsInstanceId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeLnsInstance(@PathVariable String lnsInstanceId) {
		lnsProxy.removeLNSInstance(lnsInstanceId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/wizard", produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedList<LNSInstanceWizardStep> getWizard() {
		return lnsProxy.getInstanceWizard();
	}
}
