package lora.ns.chirpstack;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cumulocity.model.event.CumulocitySeverities;

import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lora.exception.LoraError;
import lora.rest.LoraContextService;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GrpcExceptionHandler {

    private final LoraContextService loraContextService;

    @ExceptionHandler(StatusRuntimeException.class)
    private ResponseEntity<LoraError> processGrpcStatusRuntimeException(StatusRuntimeException e) {
        loraContextService.error(e.getMessage(), e);
        loraContextService.sendAlarm(e.getClass().getSimpleName(), e.getMessage(), CumulocitySeverities.CRITICAL);
        log.error("gRPC StatusRuntimeException occurred", e);
        return new ResponseEntity<>(new LoraError(e.getMessage(), e.getClass().getSimpleName()),
                HttpStatus.resolve(e.getStatus().getCode().value()));
    }
}
