package lora.ns.connector;

import java.util.Properties;

import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;

import lora.ns.LNSProxy;

public abstract class ALNSInstance implements LNSInstance {

	protected Properties properties = new Properties();
	protected String id;
	protected String name;
	protected String type;

	protected ALNSInstance(Properties properties) {
		this.setProperties(properties);
	}
	
	protected ALNSInstance(ManagedObjectRepresentation instance) {
		this.id = instance.getId().getValue();
		this.name = instance.getName();
		this.type = instance.getProperty(LNSProxy.LNS_ID).toString();
	}

	@Override
	public String getId() {
		return this.id;
	}

	abstract protected void init();

	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
		init();
	}

	@Override
	public Properties getProperties() {
		return properties;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}
}
