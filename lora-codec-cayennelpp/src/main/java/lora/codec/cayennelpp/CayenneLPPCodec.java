package lora.codec.cayennelpp;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cumulocity.model.measurement.MeasurementValue;
import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;
import com.cumulocity.rest.representation.measurement.MeasurementRepresentation;

import c8y.Position;
import c8y.RequiredAvailability;
import lora.codec.C8YData;
import lora.codec.DeviceCodec;
import lora.codec.DownlinkData;

@Component
public class CayenneLPPCodec extends DeviceCodec {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private enum LPP_TYPE {
		DIGITAL_INPUT((byte)0x00) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal value = new BigDecimal(0xff & buffer.get());
				c8yData.addMeasurement(mor, "data_" + channel, this.name().toLowerCase(), "", value, dateTime);
			}
		},
		DIGITAL_OUTPUT((byte)0x01) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal value = new BigDecimal(0xff & buffer.get());
				c8yData.addMeasurement(mor, "data_" + channel, this.name().toLowerCase(), "", value, dateTime);
			}
		},
		ANALOG_INPUT((byte)0x02) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal value = new BigDecimal(0xffff & buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(100.0));
				c8yData.addMeasurement(mor, "data_" + channel, this.name().toLowerCase(), "", value, dateTime);
			}
		},
		ANALOG_OUTPUT((byte)0x03) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal value = new BigDecimal(0xffff & buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(100.0));
				c8yData.addMeasurement(mor, "data_" + channel, this.name().toLowerCase(), "", value, dateTime);
			}
		},
		ILLUMINANCE_SENSOR((byte)0x65) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal value = new BigDecimal(0xffff & buffer.order(ByteOrder.LITTLE_ENDIAN).getShort());
				c8yData.addMeasurement(mor, "data_" + channel, this.name().toLowerCase(), "", value, dateTime);
			}
		},
		PRESENCE_SENSOR((byte)0x66) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal value = new BigDecimal(0xff & buffer.get());
				c8yData.addMeasurement(mor, "data_" + channel, this.name().toLowerCase(), "", value, dateTime);
			}
		},
		TEMPERATURE_SENSOR((byte)0x67) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal value = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(10.0));
				c8yData.addMeasurement(mor, "Temperature_" + channel, "T", "°C", value, dateTime);
			}
		},
		HUMIDITY_SENSOR((byte)0x68) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal value = new BigDecimal(0xff & buffer.get()).divide(new BigDecimal(2.0));
				c8yData.addMeasurement(mor, "Humidity_" + channel, "h", "%RH", value, dateTime);
			}
		},
		ACCELEROMETER((byte)0x71) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal x = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(1000.0));
				BigDecimal y = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(1000.0));
				BigDecimal z = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(1000.0));

				MeasurementRepresentation m = new MeasurementRepresentation();
	    		Map<String, MeasurementValue> measurementValueMap = new HashMap<>();
	    		
	    		MeasurementValue mv = new MeasurementValue();
	    		mv.setValue(x);
	    		mv.setUnit("m/s²");
	    		measurementValueMap.put("x", mv);
	    		
	    		mv = new MeasurementValue();
	    		mv.setValue(y);
	    		mv.setUnit("m/s²");
	    		measurementValueMap.put("y", mv);
	    		
	    		mv = new MeasurementValue();
	    		mv.setValue(z);
	    		mv.setUnit("m/s²");
	    		measurementValueMap.put("z", mv);

	    		m.set(measurementValueMap, "Acceleration_" + channel);
	    		m.setType("Acceleration_" + channel);
	    		m.setDateTime(dateTime);
	    		c8yData.addMeasurement(m);
			}
		},
		MAGNETOMETER((byte)0x72) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal x = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(1000.0));
				BigDecimal y = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(1000.0));
				BigDecimal z = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(1000.0));

				MeasurementRepresentation m = new MeasurementRepresentation();
	    		Map<String, MeasurementValue> measurementValueMap = new HashMap<>();
	    		
	    		MeasurementValue mv = new MeasurementValue();
	    		mv.setValue(x);
	    		mv.setUnit("µT");
	    		measurementValueMap.put("x", mv);
	    		
	    		mv = new MeasurementValue();
	    		mv.setValue(y);
	    		mv.setUnit("µT");
	    		measurementValueMap.put("y", mv);
	    		
	    		mv = new MeasurementValue();
	    		mv.setValue(z);
	    		mv.setUnit("µT");
	    		measurementValueMap.put("z", mv);

	    		m.set(measurementValueMap, "MagneticField_" + channel);
	    		m.setType("MagneticField_" + channel);
	    		m.setDateTime(dateTime);
	    		
	    		c8yData.addMeasurement(m);
			}
		},
		BAROMETER((byte)0x73) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal value = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(10.0));
				c8yData.addMeasurement(mor, "Pressure_" + channel, "P", "Pa", value, dateTime);
			}
		},
		GYROMETER((byte)0x86) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal x = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(100.0));
				BigDecimal y = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(100.0));
				BigDecimal z = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(100.0));

				MeasurementRepresentation m = new MeasurementRepresentation();
	    		Map<String, MeasurementValue> measurementValueMap = new HashMap<>();
	    		
	    		MeasurementValue mv = new MeasurementValue();
	    		mv.setValue(x);
	    		mv.setUnit("°/s");
	    		measurementValueMap.put("x", mv);
	    		
	    		mv = new MeasurementValue();
	    		mv.setValue(y);
	    		mv.setUnit("°/s");
	    		measurementValueMap.put("y", mv);
	    		
	    		mv = new MeasurementValue();
	    		mv.setValue(z);
	    		mv.setUnit("°/s");
	    		measurementValueMap.put("z", mv);

	    		m.set(measurementValueMap, "Gyroscope_" + channel);
	    		m.setType("Gyroscope_" + channel);
	    		m.setDateTime(dateTime);
	    		
	    		c8yData.addMeasurement(m);
			}
		},
		GPS_LOCATION((byte)0x88) {
			@Override
			void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime) {
				BigDecimal lat = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getInt()).divide(new BigDecimal(10000.0));
				BigDecimal lng = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getInt()).divide(new BigDecimal(10000.0));
				
				Position p = new Position();
				p.setLat(lat);
				p.setLng(lng);
				
				mor.set(p);
				
				c8yData.setMorToUpdate(mor);
			}
		};
		
		public byte value;
		
		private static final Map<Byte, LPP_TYPE> BY_VALUE = new HashMap<>();
		
		static {
			for(LPP_TYPE t : values()) {
				BY_VALUE.put(t.value, t);
			}
		}
		
		private LPP_TYPE(byte value) {
			this.value = value;
		}

		abstract void process(byte channel, C8YData c8yData, ManagedObjectRepresentation mor, ByteBuffer buffer, DateTime dateTime);
	}

	@Override
	public String getId() {
		return "cayennelpp";
	}

	@Override
	public String getName() {
		return "Cayenne LPP";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	protected C8YData decode(ManagedObjectRepresentation mor, String model, int fport, DateTime updateTime, byte[] payload) {
		C8YData c8yData = new C8YData();
		ByteBuffer buffer = ByteBuffer.wrap(payload);

		byte channel = 0;
		
		switch(fport) {
		case 1:
		case 2:
			while (buffer.hasRemaining()) {
				if (fport == 1) {
					channel = buffer.get();
				}
				logger.info("Channel is: {}", channel);
				byte value = buffer.get();
				LPP_TYPE type = LPP_TYPE.BY_VALUE.get(value);
				if (type != null) {
					type.process(channel, c8yData, mor, buffer, updateTime);
					logger.info("Data decoded: {}", c8yData);
				} else {
					logger.info("{} is not a valid value", value);
				}
				if (fport == 2) {
					channel++;
				}
			}
			break;
		case 3:
			channel = buffer.get();
			BigDecimal lat = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getInt()).divide(new BigDecimal(10000.0));
			BigDecimal lng = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getInt()).divide(new BigDecimal(10000.0));
			BigDecimal alt = new BigDecimal(buffer.order(ByteOrder.BIG_ENDIAN).getShort()).divide(new BigDecimal(10000.0));
			Position p = new Position();
			p.setLat(lat);
			p.setLng(lng);
			p.setAlt(alt);
			mor.set(p);
			c8yData.setMorToUpdate(mor);
			break;
		case 11:
			short mask = buffer.getShort();
			if ((mask & 0x01) > 0) {
				DateTime utcTime = new DateTime(new Long(buffer.order(ByteOrder.BIG_ENDIAN).getInt()) * 1000L);
				logger.info("Current device time is {}", utcTime);
			}
			if ((mask & 0x02) > 0) {
				int period = buffer.order(ByteOrder.BIG_ENDIAN).getInt();
				RequiredAvailability requiredAvailability = new RequiredAvailability(period / 60 + 1);
				mor.set(requiredAvailability);
				c8yData.setMorToUpdate(mor);
			}
			if ((mask & 0x04) > 0) {
				int readingPeriod = buffer.order(ByteOrder.BIG_ENDIAN).getInt();
				logger.info("Device reading period is {} minutes", readingPeriod / 60);
			}
		}
		
		return c8yData;
	}

	@Override
	public List<String> getModels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DownlinkData encode(ManagedObjectRepresentation mor, String model, String operation) {
		// TODO Auto-generated method stub
		return null;
	}

}
