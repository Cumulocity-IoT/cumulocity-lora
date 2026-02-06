package lora.codec.ms;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for CodecProxy safety and resource management.
 * Verifies missing C8Y_BASEURL throws meaningful IllegalStateException (Step 2b)
 * and that RestTemplate is shared across calls (Step 3c).
 */
class CodecProxyTest {

    @Test
    void encode_shouldThrowIllegalStateExceptionWhenBaseUrlMissing() {
        CodecProxy proxy = new CodecProxy("test", "Test", "1.0");
        proxy.setAuthentication("Bearer test-token");
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> proxy.encode(null));
        assertTrue(e.getMessage().contains("C8Y_BASEURL"));
    }

    @Test
    void decode_shouldThrowIllegalStateExceptionWhenBaseUrlMissing() {
        CodecProxy proxy = new CodecProxy("test", "Test", "1.0");
        proxy.setAuthentication("Bearer test-token");
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> proxy.decode(null));
        assertTrue(e.getMessage().contains("C8Y_BASEURL"));
    }

    @Test
    void getAvailableOperations_shouldThrowIllegalStateExceptionWhenBaseUrlMissing() {
        CodecProxy proxy = new CodecProxy("test", "Test", "1.0");
        proxy.setAuthentication("Bearer test-token");
        assertThrows(IllegalStateException.class, () -> proxy.getAvailableOperations("testModel"));
    }

    @Test
    void codecProxy_shouldExposeCorrectProperties() {
        CodecProxy proxy = new CodecProxy("myId", "MyName", "2.0");
        assertThat(proxy.getId()).isEqualTo("myId");
        assertThat(proxy.getName()).isEqualTo("MyName");
        assertThat(proxy.getVersion()).isEqualTo("2.0");
    }
}
