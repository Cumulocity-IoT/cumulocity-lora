package lora.ns.chirpstack;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cumulocity.model.event.CumulocitySeverities;

import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lora.ns.exception.LoraError;
import lora.rest.LoraContextService;

@RestControllerAdvice
@RequiredArgsConstructor
public class GrpcExceptionHandler {

    private final LoraContextService loraContextService;

    @ExceptionHandler(StatusRuntimeException.class)
    private ResponseEntity<LoraError> processGrpcStatusRuntimeException(StatusRuntimeException e) {
        loraContextService.error(e.getMessage(), e);
        loraContextService.sendAlarm(e.getClass().getSimpleName(), e.getMessage(), CumulocitySeverities.CRITICAL);
        StringWriter detailedMessage = new StringWriter();
        e.printStackTrace(new PrintWriter(detailedMessage));
        return new ResponseEntity<>(new LoraError(e.getMessage(), detailedMessage.toString()),
                HttpStatus.resolve(e.getStatus().getCode().value()));
    }
}
