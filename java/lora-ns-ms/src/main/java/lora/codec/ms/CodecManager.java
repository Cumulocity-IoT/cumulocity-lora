package lora.codec.ms;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Hex;
import org.joda.time.DateTime;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.cumulocity.microservice.context.credentials.MicroserviceCredentials;
import com.cumulocity.microservice.subscription.model.MicroserviceSubscriptionAddedEvent;
import com.cumulocity.microservice.subscription.service.MicroserviceSubscriptionsService;
import com.cumulocity.model.ID;
import com.cumulocity.model.event.CumulocitySeverities;
import com.cumulocity.rest.representation.alarm.AlarmRepresentation;
import com.cumulocity.rest.representation.event.EventRepresentation;
import com.cumulocity.rest.representation.identity.ExternalIDRepresentation;
import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;
import com.cumulocity.rest.representation.operation.OperationRepresentation;
import com.cumulocity.sdk.client.SDKException;
import com.cumulocity.sdk.client.alarm.AlarmApi;
import com.cumulocity.sdk.client.event.EventApi;
import com.cumulocity.sdk.client.identity.IdentityApi;
import com.cumulocity.sdk.client.inventory.InventoryApi;
import com.cumulocity.sdk.client.inventory.InventoryFilter;
import com.cumulocity.sdk.client.inventory.ManagedObjectCollection;

import c8y.Command;
import c8y.Configuration;
import c8y.Hardware;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lora.codec.DeviceCodecRepresentation;
import lora.codec.downlink.DeviceOperationElement;
import lora.codec.downlink.DownlinkData;
import lora.codec.downlink.Encode;
import lora.codec.uplink.Decode;
import lora.common.C8YUtils;
import lora.exception.CannotDecodePayloadException;
import lora.exception.CannotEncodePayloadException;
import lora.ns.DeviceData;

@Service
@Slf4j
@RequiredArgsConstructor
public class CodecManager {

	private static final String PROPERTY_PROCESSED = "processed";
	private static final String PROPERTY_CODEC = "codec";
	private static final String PROPERTY_STATUS = "status";
	private static final String VALUE_PROCESSED = "processed";
	private static final String VALUE_UNPROCESSED = "unprocessed";
	private static final String LORA_DEVICE_COMMAND_ERROR = "LoRa device command error";
	private static final String LORA_DEVICE_PAYLOAD_ERROR = "LoRa device payload decoding error";

	private final EventApi eventApi;
	private final InventoryApi inventoryApi;
	private final IdentityApi identityApi;
	private final AlarmApi alarmApi;
	private final MicroserviceSubscriptionsService subscriptionsService;
	private final C8YUtils c8yUtils;

	private Map<String, CodecProxy> codecInstances = new HashMap<>();

	@EventListener
	private void updateCodecsList(MicroserviceSubscriptionAddedEvent event) {
		InventoryFilter filter = new InventoryFilter().byType(C8YUtils.CODEC_TYPE);
		ManagedObjectCollection col = inventoryApi.getManagedObjectsByFilter(filter);
		for (ManagedObjectRepresentation mor : col.get().allPages()) {
			DeviceCodecRepresentation codec = mor.get(DeviceCodecRepresentation.class);
			if (codec != null) {
				log.info("Adding to codec list: {} {}", codec.getName(), codec.getVersion());
				codecInstances.put(codec.getId(), new CodecProxy(codec.getId(), codec.getName(), codec.getVersion()));
			}
		}
	}

	private ExternalIDRepresentation findExternalId(String externalId, String type) {
		ID id = new ID();
		id.setType(type);
		id.setValue(externalId);
		ExternalIDRepresentation extId = null;
		try {
			extId = identityApi.getExternalId(id);
		} catch (SDKException e) {
			log.info("External ID {} not found", externalId);
		}
		return extId;
	}

	public CodecProxy getCodec(String id) {
		CodecProxy result = codecInstances.get(id);
		if (result == null) {
			log.info("Codec {} not in cache, will get it from inventory.", id);
			ExternalIDRepresentation extId = findExternalId(id, C8YUtils.CODEC_ID);
			if (extId != null) {
				ManagedObjectRepresentation mor = inventoryApi.get(extId.getManagedObject().getId());
				DeviceCodecRepresentation codec = mor.get(DeviceCodecRepresentation.class);
				if (codec != null) {
					result = new CodecProxy(id, codec.getName(), codec.getVersion());
					codecInstances.put(id, result);
				} else {
					codec = new DeviceCodecRepresentation();
					codec.setId(id);
					codec.setName("codec_name");
					codec.setVersion("codec_version");
					log.warn("Codec {} exists in inventory but structure is wrong: {}", id, mor.toJSON());
					mor = new ManagedObjectRepresentation();
					mor.set(codec);
					log.warn("Codec structure should look like: {}", mor.toJSON());
				}
			} else {
				log.warn("No external id could be found for {}.", id);
			}
		}
		if (result == null) {
			log.warn("Codec {} is not available on that tenant.", id);
		}
		return result;
	}

	private Optional<CodecProxy> getCodec(ManagedObjectRepresentation device) {
		CodecProxy codec = null;
		Optional<CodecProxy> result = Optional.empty();
		if (device.hasProperty(PROPERTY_CODEC)) {
			codec = getCodec(device.getProperty(PROPERTY_CODEC).toString());
			Optional<MicroserviceCredentials> credentials = subscriptionsService
					.getCredentials(subscriptionsService.getTenant());
			if (codec != null && credentials.isPresent()) {
				String authentication = credentials.get().toCumulocityCredentials().getAuthenticationString();
				codec.setAuthentication(authentication);
				result = Optional.of(codec);
			} else {
				if (codec == null) {
					log.error("Codec {} does not exist.", device.getProperty(PROPERTY_CODEC));
				} else {
					log.error("Could not retrieve microservice credentials.");
				}
			}
		} else {
			log.info(
					"Device has no codec information. Payload will be stored for later parsing when Codec will be provided.");
		}
		return result;
	}

	public void decode(ManagedObjectRepresentation mor, DeviceData event) {
		EventRepresentation eventRepresentation = new EventRepresentation();
		eventRepresentation.setSource(mor);
		eventRepresentation.setDateTime(new DateTime(event.getDateTime()));
		eventRepresentation.setText("LoRa raw payload");
		eventRepresentation.setType("LoRaPayload");
		eventRepresentation.setProperty("payload", Hex.encodeHexString(event.getPayload()));
		eventRepresentation.setProperty("port", event.getfPort());
		log.info("Device details: {}", mor.toJSON());
		eventRepresentation.setProperty(PROPERTY_PROCESSED, false);
		eventRepresentation.setProperty(PROPERTY_STATUS, VALUE_UNPROCESSED);
		getCodec(mor).ifPresent(codec -> {
			log.info("Codec {} will be used with device {} for decoding payload {} on port {}",
					mor.getProperty(PROPERTY_CODEC), event.getDevEui(), event.getPayload(), event.getfPort());
			try {
				codec.decode(new Decode(event));
				eventRepresentation.setProperty(PROPERTY_PROCESSED, true);
				eventRepresentation.setProperty(PROPERTY_STATUS, VALUE_PROCESSED);
				c8yUtils.callWithoutAppContext(() -> eventApi.create(eventRepresentation));
			} catch (CannotDecodePayloadException e) {
				eventRepresentation.setProperty(PROPERTY_PROCESSED, false);
				eventRepresentation.setProperty(PROPERTY_STATUS, VALUE_UNPROCESSED);
				c8yUtils.callWithoutAppContext(() -> eventApi.create(eventRepresentation));
				AlarmRepresentation alarm = new AlarmRepresentation();
				alarm.setSource(mor);
				alarm.setType(LORA_DEVICE_PAYLOAD_ERROR);
				alarm.setText(e.getMessage());
				alarm.setDateTime(new DateTime());
				alarm.setSeverity(CumulocitySeverities.CRITICAL.name());
				alarmApi.create(alarm);
				throw e;
			}
		});
	}

	public DownlinkData encode(String devEui, OperationRepresentation operation) {
		DownlinkData[] data = { null };
		ManagedObjectRepresentation mor = inventoryApi.get(operation.getDeviceId());
		getCodec(mor).ifPresent(codec -> {
			Hardware hardware = mor.get(Hardware.class);
			String command = "";
			if (operation.get(Command.class) != null) {
				command = operation.get(Command.class).getText();
			} else if (operation.get(Configuration.class) != null) {
				command = "{\"set config\": " + operation.get(Configuration.class).getConfig() + "}";
			}
			log.info("Codec {} will be used with device {} for encoding operation {}", mor.getProperty(PROPERTY_CODEC),
					devEui, command);
			try {
				data[0] = codec.encode(new Encode(devEui, command, hardware != null ? hardware.getModel() : null));
				log.info("Result of command \"{}\" is payload {}", command, data[0].getPayload());
			} catch (CannotEncodePayloadException e) {
				log.error(e.getMessage());
				AlarmRepresentation alarm = new AlarmRepresentation();
				alarm.setSource(mor);
				alarm.setType(LORA_DEVICE_COMMAND_ERROR);
				alarm.setText(e.getMessage());
				alarm.setDateTime(new DateTime());
				alarm.setSeverity(CumulocitySeverities.CRITICAL.name());
				alarmApi.create(alarm);
				throw e;
			}
		});
		return data[0];
	}

	public Map<String, DeviceOperationElement> getAvailableOperations(ManagedObjectRepresentation mor) {
		Map<String, DeviceOperationElement> result = null;
		if (mor.hasProperty(PROPERTY_CODEC)) {
			CodecProxy codec = getCodec(mor.getProperty(PROPERTY_CODEC).toString());
			Optional<MicroserviceCredentials> credentials = subscriptionsService
					.getCredentials(subscriptionsService.getTenant());
			if (codec != null && credentials.isPresent()) {
				String authentication = credentials.get().toCumulocityCredentials().getAuthenticationString();
				codec.setAuthentication(authentication);
				String model = null;
				if (mor.get(Hardware.class) != null) {
					model = mor.get(Hardware.class).getModel();
				}
				result = codec.getAvailableOperations(model);
			} else {
				if (codec == null) {
					log.error("Codec {} does not exist.", mor.getProperty(PROPERTY_CODEC));
				} else {
					log.error("Could not retrieve microservice credentials.");
				}
			}
		}
		return result;
	}

	public Map<String, CodecProxy> getCodecs() {
		return codecInstances;
	}
}
