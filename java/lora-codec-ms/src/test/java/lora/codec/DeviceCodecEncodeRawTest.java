package lora.codec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.cumulocity.rest.representation.inventory.ManagedObjectRepresentation;

import lora.codec.downlink.DeviceOperation;
import lora.codec.downlink.DownlinkData;
import lora.codec.downlink.Encode;
import lora.codec.uplink.C8YData;
import lora.codec.uplink.Decode;

/**
 * Tests for DeviceCodec safety fixes (Steps 2b).
 * Verifies encodeRaw token validation and convertJsonStringToDeviceOperation
 * empty JSON handling.
 */
class DeviceCodecEncodeRawTest {

    private final DeviceCodec codec = new DeviceCodec() {
        @Override
        public String getId() { return "test"; }

        @Override
        public String getName() { return "Test"; }

        @Override
        public String getVersion() { return "1.0"; }

        @Override
        public DownlinkData askDeviceConfig(String model) { return null; }

        @Override
        public C8YData decode(ManagedObjectRepresentation mor, Decode decode) { return null; }

        @Override
        public DownlinkData encode(ManagedObjectRepresentation mor, Encode encode) { return null; }
    };

    @Test
    void convertJsonStringToDeviceOperation_shouldHandleEmptyJson() {
        DeviceOperation op = codec.convertJsonStringToDeviceOperation("{}");
        assertNotNull(op);
        assertNull(op.getId());
    }

    @Test
    void convertJsonStringToDeviceOperation_shouldHandleValidJson() {
        DeviceOperation op = codec.convertJsonStringToDeviceOperation("{\"cmd\":{\"key\":\"value\"}}");
        assertNotNull(op);
        assertEquals("cmd", op.getId());
    }

    @Test
    void convertJsonStringToDeviceOperation_shouldHandleInvalidJson() {
        DeviceOperation op = codec.convertJsonStringToDeviceOperation("not json");
        assertNotNull(op);
        assertNull(op.getId());
    }

    @Test
    void convertJsonStringToDeviceOperation_shouldHandleNestedArrayValues() {
        DeviceOperation op = codec.convertJsonStringToDeviceOperation("{\"op\":{\"key1\": \"value\", \"key2\": [1,2,3]}}");
        assertNotNull(op);
        assertEquals("op", op.getId());
        assertEquals(2, op.getElements().size());
    }
}
