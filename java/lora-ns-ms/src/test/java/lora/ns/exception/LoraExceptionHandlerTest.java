package lora.ns.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.cumulocity.sdk.client.SDKException;

import lora.exception.LoraError;
import lora.exception.LoraException;

/**
 * Tests for LoraExceptionHandler error response pattern (Step 1b fix).
 * Verifies that the LoraError construction pattern uses class simple name,
 * NOT stack traces, in the detailedMessage field.
 */
class LoraExceptionHandlerTest {

	@Test
	void loraError_shouldContainClassNameNotStackTrace() {
		LoraException exception = new LoraException("Something went wrong");
		LoraError error = new LoraError(exception.getMessage(), exception.getClass().getSimpleName());

		assertThat(error.getMessage()).isEqualTo("Something went wrong");
		assertThat(error.getDetailedMessage()).isEqualTo("LoraException");
		assertThat(error.getDetailedMessage()).doesNotContain("at lora.");
		assertThat(error.getDetailedMessage()).doesNotContain("\n");
		assertThat(error.getDetailedMessage()).doesNotContain("java.lang");
	}

	@Test
	void sdkExceptionError_shouldContainClassNameNotStackTrace() {
		SDKException exception = new SDKException(500, "SDK error");
		LoraError error = new LoraError(exception.getMessage(), exception.getClass().getSimpleName());

		assertThat(error.getDetailedMessage()).isEqualTo("SDKException");
		assertThat(error.getDetailedMessage()).doesNotContain("at com.cumulocity");
		assertThat(error.getDetailedMessage()).doesNotContain("\n");
	}

	@Test
	void feignExceptionError_shouldContainClassNameNotStackTrace() {
		feign.Request request = feign.Request.create(feign.Request.HttpMethod.GET, "/test",
				java.util.Collections.emptyMap(), null, feign.Util.UTF_8);
		feign.FeignException.BadRequest exception = new feign.FeignException.BadRequest(
				"Bad request", request, null, null);
		LoraError error = new LoraError(exception.getMessage(), exception.getClass().getSimpleName());

		assertThat(error.getDetailedMessage()).isEqualTo("BadRequest");
		assertThat(error.getDetailedMessage()).doesNotContain("at feign.");
		assertThat(error.getDetailedMessage()).doesNotContain("\n");
	}

	@Test
	void loraErrorFromNestedCause_shouldNotLeakStackTrace() {
		RuntimeException cause = new RuntimeException("root cause");
		LoraException exception = new LoraException("wrapper", cause);

		LoraError error = new LoraError(exception.getMessage(), exception.getClass().getSimpleName());
		assertThat(error.getDetailedMessage()).isEqualTo("LoraException");
		assertThat(error.getDetailedMessage()).doesNotContain("at java.");
		assertThat(error.getDetailedMessage()).doesNotContain("Caused by");
	}
}
