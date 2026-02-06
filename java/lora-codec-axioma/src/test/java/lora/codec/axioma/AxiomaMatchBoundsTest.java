package lora.codec.axioma;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Tests for AxiomaCodec.match() bounds checking (Step 2a fix).
 * Verifies that out-of-bounds positions return null instead of
 * causing ArrayIndexOutOfBoundsException.
 */
class AxiomaMatchBoundsTest {

	private final AxiomaCodec codec = new AxiomaCodec();

	@Test
	void match_shouldReturnNullForNegativePosition() {
		byte[] bytes = new byte[] { 0x13 };
		assertNull(codec.match(bytes, -1));
	}

	@Test
	void match_shouldReturnNullForPositionAtLength() {
		byte[] bytes = new byte[] { 0x13 };
		assertNull(codec.match(bytes, 1));
	}

	@Test
	void match_shouldReturnNullForPositionBeyondLength() {
		byte[] bytes = new byte[] { 0x13 };
		assertNull(codec.match(bytes, 5));
	}

	@Test
	void match_shouldReturnNullForEmptyArray() {
		assertNull(codec.match(new byte[0], 0));
	}

	@Test
	void match_shouldReturnNullForUnknownByte() {
		byte[] bytes = new byte[] { 0x00 };
		assertNull(codec.match(bytes, 0));
	}
}
