package lora.ns.connector;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.cumulocity.rest.representation.operation.OperationRepresentation;

import lora.codec.DownlinkData;
import lora.ns.DeviceProvisioning;
import lora.ns.EndDevice;

public interface LNSConnector {
	String getId();
	String getType();
	String getName();
	List<EndDevice> getDevices();
	void setProperties(Properties properties);
	Properties getProperties();
	Optional<EndDevice> getDevice(String devEui);
	String processOperation(DownlinkData operation, OperationRepresentation c8yOperation);
	boolean provisionDevice(DeviceProvisioning deviceProvisioning);
	void configureRoutings(String url, String tenant, String login, String password);
	void removeRoutings();
	boolean deprovisionDevice(String deveui);
}
