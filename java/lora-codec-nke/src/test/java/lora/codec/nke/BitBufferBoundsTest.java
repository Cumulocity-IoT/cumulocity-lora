package lora.codec.nke;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests for BitBuffer bounds validation (Step 2a fix).
 * Verifies that buffer overflow conditions throw exceptions instead of
 * causing ArrayIndexOutOfBoundsException.
 */
class BitBufferBoundsTest {

	@Test
	void getNextSample_shouldThrowOnEmptyBuffer() {
		BitBuffer buffer = new BitBuffer(new byte[0]);
		Exception e = assertThrows(Exception.class, () -> buffer.getNextSample(BitBuffer.ST_U8));
		assertTrue(e.getMessage().contains("Buffer overflow"));
	}

	@Test
	void getNextSample_shouldThrowWhenRequestingMoreBitsThanAvailable() {
		BitBuffer buffer = new BitBuffer(new byte[] { 0x01 }); // 8 bits
		Exception e = assertThrows(Exception.class, () -> buffer.getNextSample(BitBuffer.ST_U16));
		assertTrue(e.getMessage().contains("Buffer overflow"));
	}

	@Test
	void getNextSample_shouldSucceedWithSufficientData() {
		BitBuffer buffer = new BitBuffer(new byte[] { 0x42, 0x00 }); // 16 bits
		assertDoesNotThrow(() -> buffer.getNextSample(BitBuffer.ST_U8));
	}

	@Test
	void getNextSample_shouldThrowOnZeroBits() {
		BitBuffer buffer = new BitBuffer(new byte[] { 0x01 });
		Exception e = assertThrows(Exception.class, () -> buffer.getNextSample(BitBuffer.ST_U8, 0));
		assertTrue(e.getMessage().contains("Buffer overflow"));
	}

	@Test
	void getNextSample_shouldThrowAfterBufferExhausted() {
		BitBuffer buffer = new BitBuffer(new byte[] { 0x01 }); // 8 bits
		assertDoesNotThrow(() -> buffer.getNextSample(BitBuffer.ST_U8)); // consume all 8 bits
		Exception e = assertThrows(Exception.class, () -> buffer.getNextSample(BitBuffer.ST_U8));
		assertTrue(e.getMessage().contains("Buffer overflow"));
	}

	@Test
	void getNextBifromHi_shouldThrowOnEmptyBuffer() {
		BitBuffer buffer = new BitBuffer(new byte[0]);
		assertThrows(Exception.class, () -> buffer.getNextBifromHi(0));
	}
}
