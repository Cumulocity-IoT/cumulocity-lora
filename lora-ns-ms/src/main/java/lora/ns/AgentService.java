package lora.ns;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cumulocity.microservice.subscription.service.MicroserviceSubscriptionsService;
import com.cumulocity.model.Agent;
import com.cumulocity.model.idtype.GId;
import com.cumulocity.rest.representation.identity.ExternalIDRepresentation;
import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;
import com.cumulocity.rest.representation.operation.OperationRepresentation;
import com.cumulocity.sdk.client.SDKException;
import com.cumulocity.sdk.client.devicecontrol.DeviceControlApi;
import com.cumulocity.sdk.client.identity.IdentityApi;
import com.cumulocity.sdk.client.inventory.InventoryApi;
import com.cumulocity.sdk.client.notification.Subscription;
import com.cumulocity.sdk.client.notification.SubscriptionListener;

import c8y.IsDevice;
import c8y.RequiredAvailability;
import lora.common.C8YUtils;
import lora.ns.connector.LNSInstance;
import lora.ns.operation.LNSOperationManager;

@Service
public class AgentService {
	public Logger logger;
	@Autowired
	private C8YUtils c8yUtils;
	@Autowired
	private InventoryApi inventoryApi;
	@Autowired
	private IdentityApi identityApi;
	@Autowired
	private DeviceControlApi deviceControlApi;
	@Autowired
	private MicroserviceSubscriptionsService subscriptionsService;
	@Autowired
	private LNSOperationManager lnsOperationManager;

	private Map<String, ManagedObjectRepresentation> agents;


	public void registerAgent(LNSProxy<? extends LNSInstance> lnsProxy) {
		ExternalIDRepresentation extId = c8yUtils.findExternalId(lnsProxy.getId(), LNSProxy.LNS_EXT_ID);
		ManagedObjectRepresentation agent = null;
		if (extId == null) {
			agent = new ManagedObjectRepresentation();
			agent.setType(LNSProxy.LNS_TYPE);
			agent.setName(lnsProxy.getName());
			agent.setProperty("version", lnsProxy.getVersion());
			agent.setProperty(LNSProxy.LNS_ID, lnsProxy.getId());
			agent.set(new RequiredAvailability(5));
			agent.set(new Agent());
			agent.set(new IsDevice());
			agent = inventoryApi.create(agent);

			extId = new ExternalIDRepresentation();
			extId.setExternalId(lnsProxy.getId());
			extId.setType(LNSProxy.LNS_EXT_ID);
			extId.setManagedObject(agent);
			identityApi.create(extId);
		} else {
			agent = inventoryApi.get(extId.getManagedObject().getId());
			agent.setLastUpdatedDateTime(null);
			agent.setName(lnsProxy.getName());
			agent.setProperty("version", lnsProxy.getVersion());
			agent.setProperty(LNSProxy.LNS_ID, lnsProxy.getId());
			agent.set(new RequiredAvailability(5));
			if (agent.get(Agent.class) == null) {
				agent.set(new Agent());
			}
			if (agent.get(IsDevice.class) == null) {
				agent.set(new IsDevice());
			}
			inventoryApi.update(agent);
		}
		agents.put(subscriptionsService.getTenant(), agent);
		deviceControlApi.getNotificationsSubscriber().subscribe(agent.getId(),
				new OperationDispatcherSubscriptionListener(subscriptionsService.getTenant()));
	}
	
	public ManagedObjectRepresentation getAgent() {
		return agents.get(subscriptionsService.getTenant());
	}
	

	public class OperationDispatcherSubscriptionListener
			implements SubscriptionListener<GId, OperationRepresentation> {

		public OperationDispatcherSubscriptionListener(String tenant) {
			this.tenant = tenant;
		}

		private String tenant;

		@Override
		public void onError(Subscription<GId> sub, Throwable e) {
			logger.error("OperationDispatcher error!", e);
		}

		@Override
		public void onNotification(Subscription<GId> sub, OperationRepresentation operation) {
			try {
				subscriptionsService.runForTenant(tenant, () -> {
					lnsOperationManager.executePending(operation);
				});
			} catch (SDKException e) {
				logger.error("OperationDispatcher error!", e);
			}
		}
	}

}