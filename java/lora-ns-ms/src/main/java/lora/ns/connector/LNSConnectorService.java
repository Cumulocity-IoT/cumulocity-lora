package lora.ns.connector;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cumulocity.microservice.subscription.service.MicroserviceSubscriptionsService;
import com.cumulocity.model.idtype.GId;
import com.cumulocity.sdk.client.SDKException;
import com.cumulocity.sdk.client.inventory.InventoryApi;
import com.google.common.collect.Maps;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lora.ns.exception.ConnectorDoesNotExistException;

@Service
@RequiredArgsConstructor
@Slf4j
public class LNSConnectorService {

	private Map<String, Map<String, LNSConnector>> connectors = new HashMap<>();

	private final MicroserviceSubscriptionsService subscriptionsService;

	private final InventoryApi inventoryApi;

	public LNSConnector getConnector(String lnsConnectorId) {
		var lnsConnector = getConnectors().get(lnsConnectorId);
		if (lnsConnector == null) {
			log.error("Trying to access connector {} in tenant {} which doesn't seem to be loaded.", lnsConnectorId, subscriptionsService.getTenant());
			// Let's first check that the connector is not in the inventory
			try {
				var mor = inventoryApi.get(GId.asGId(lnsConnectorId));
				if (mor != null) {
					log.error("Connector {} exists but is not loaded in tenant {}.", lnsConnectorId, subscriptionsService.getTenant());
					log.info("Full connector object: {}", mor.toJSON());
				}
			} catch (SDKException e) {
				log.error("Couldn't fetch connector {} from inventory", lnsConnectorId, e);
			}
			throw new ConnectorDoesNotExistException(lnsConnectorId);
		}
		return lnsConnector;
	}

	public void removeConnector(String lnsConnectorId) {
		getConnectors().remove(lnsConnectorId);
	}

	public void addConnector(LNSConnector connector) {
		getConnectors().put(connector.getId(), connector);
	}

	public Map<String, LNSConnector> getConnectors() {
		if (!connectors.containsKey(subscriptionsService.getTenant())) {
			log.info("No connectors yet in tenant {}. Initializing the collection...", subscriptionsService.getTenant());
			connectors.put(subscriptionsService.getTenant(), new HashMap<>());
		}
		return connectors.get(subscriptionsService.getTenant());
	}

	public Map<String, LNSConnectorRepresentation> getConnectorRepresentations() {
		return Maps.transformValues(connectors.get(subscriptionsService.getTenant()), v -> {
			LNSConnectorRepresentation connectorRepresentation = new LNSConnectorRepresentation();
			connectorRepresentation.setName(v.getName());
			connectorRepresentation.setProperties(v.getProperties());
			return connectorRepresentation;
		});
	}
}
