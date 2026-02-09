package lora.ns.scheduling;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import com.cumulocity.microservice.subscription.service.MicroserviceSubscriptionsService;
import com.cumulocity.model.operation.OperationStatus;
import com.cumulocity.rest.representation.measurement.MeasurementRepresentation;
import com.cumulocity.rest.representation.operation.OperationCollectionRepresentation;
import com.cumulocity.sdk.client.devicecontrol.DeviceControlApi;
import com.cumulocity.sdk.client.devicecontrol.OperationCollection;
import com.cumulocity.sdk.client.devicecontrol.OperationFilter;
import com.cumulocity.sdk.client.measurement.MeasurementApi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lora.codec.uplink.C8YData;
import lora.ns.agent.AgentService;
import lora.ns.connector.LNSConnector;
import lora.ns.connector.LNSConnectorService;
import lora.ns.gateway.LNSGatewayService;
import lora.ns.operation.LNSOperationService;
import lora.rest.LoraContextService;

@Service
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class LNSSchedulingService {

	private final MicroserviceSubscriptionsService subscriptionsService;
	private final LNSConnectorService lnsConnectorManager;
	private final LoraContextService loraContextService;
	private final LNSGatewayService lnsGatewayManager;
	private final DeviceControlApi deviceControlApi;
	private final LNSOperationService lnsOperationManager;
	private final AgentService agentService;
	private final MeasurementApi measurementApi;

	@Scheduled(initialDelay = 10000, fixedDelay = 300000)
	private void scanGateways() {
		subscriptionsService.runForEachTenant(() -> {
			Map<String, LNSConnector> connectors = lnsConnectorManager.getConnectors();
			if (connectors != null) {
				connectors.values().forEach(c -> {
					if (c.hasGatewayManagementCapability()) {
						loraContextService.log("Scanning gateways in tenant {} with connector {}",
								subscriptionsService.getTenant(), c.getName());
						lnsGatewayManager.upsertGateways(c);
					}
				});
			}
		});
	}

	@Scheduled(initialDelay = 10000, fixedDelay = 10000)
	private void processPendingOperations() {
		subscriptionsService.runForEachTenant(() -> {
			String currentTenant = subscriptionsService.getTenant();
			lnsConnectorManager.getConnectors().values().forEach(connector -> {
				log.info("Checking pending operations in tenant {} for connector {}", subscriptionsService.getTenant(),
						connector.getName());
				OperationCollection oc = deviceControlApi.getOperationsByFilter(
						new OperationFilter().byStatus(OperationStatus.PENDING).byAgent(connector.getId()));
				if (oc != null) {
					for (OperationCollectionRepresentation opCollectionRepresentation = oc
							.get(); opCollectionRepresentation != null
									&& !opCollectionRepresentation.getOperations()
											.isEmpty(); opCollectionRepresentation = oc
													.getNextPage(opCollectionRepresentation)) {
						loraContextService.log("Processing pending operations on tenant {} - page {}", currentTenant,
								oc.get().getPageStatistics().getCurrentPage());
						opCollectionRepresentation.getOperations()
								.forEach(lnsOperationManager::executePending);
					}
				}
			});
		});
	}

	@Scheduled(initialDelay = 10000, fixedDelay = 300000)
	private void sendMetrics() {
		subscriptionsService.runForEachTenant(() -> {
			C8YData c8yData = new C8YData();
			DateTime now = new DateTime();
			String memoryFragment = "Memory";
			String bytesUnit = "bytes";
			c8yData.addMeasurement(agentService.getAgent(), memoryFragment, "Max Memory", bytesUnit,
					BigDecimal.valueOf(Runtime.getRuntime().maxMemory()), now);
			c8yData.addMeasurement(agentService.getAgent(), memoryFragment, "Free Memory", bytesUnit,
					BigDecimal.valueOf(Runtime.getRuntime().freeMemory()), now);
			c8yData.addMeasurement(agentService.getAgent(), memoryFragment, "Total Memory", bytesUnit,
					BigDecimal.valueOf(Runtime.getRuntime().totalMemory()), now);
			for (MeasurementRepresentation m : c8yData.getMeasurements()) {
				measurementApi.create(m);
			}
		});
	}

	@Bean
	public ThreadPoolTaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.initialize();
		taskScheduler.setPoolSize(20);
		taskScheduler.schedule(this::scanGateways, new Trigger() {
			@Override
			public Instant nextExecution(TriggerContext triggerContext) {
				Instant lastExecution = triggerContext.lastActualExecution();
				if (lastExecution != null) {
					return lastExecution.plusMillis(agentService.getGatewayScanRate());
				}
				return Instant.now().plusMillis(agentService.getGatewayScanStartDelay());
			}
		});
		return taskScheduler;
	}
}
