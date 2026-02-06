package lora.ns.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cumulocity.model.event.CumulocitySeverities;
import com.cumulocity.sdk.client.SDKException;

import feign.FeignException;
import feign.FeignException.FeignClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lora.exception.LoraError;
import lora.exception.LoraException;
import lora.rest.LoraContextService;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class LoraExceptionHandler {

    private final LoraContextService loraContextService;

    @ExceptionHandler(LoraException.class)
    private ResponseEntity<LoraError> processLoraException(LoraException e) {
        if (e.getCause() instanceof FeignClientException fe) {
            return processFeignException(fe);
        }
        loraContextService.error(e.getMessage(), e);
        loraContextService.sendAlarm(e.getClass().getSimpleName(), e.getMessage(), CumulocitySeverities.CRITICAL);
        log.error("LoraException occurred", e);
        return new ResponseEntity<>(new LoraError(e.getMessage(), e.getClass().getSimpleName()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignClientException.class)
    ResponseEntity<LoraError> processFeignClientException(FeignClientException e) {
        loraContextService.error(e.getMessage(), e);
        loraContextService.sendAlarm(e.getClass().getSimpleName(), e.getMessage(), CumulocitySeverities.CRITICAL);
        log.error("FeignClientException occurred", e);
        return new ResponseEntity<>(new LoraError(e.getMessage(), e.getClass().getSimpleName()),
                HttpStatus.resolve(e.status()));
    }

    @ExceptionHandler(FeignException.class)
    ResponseEntity<LoraError> processFeignException(FeignException e) {
        loraContextService.error(e.getMessage(), e);
        loraContextService.sendAlarm(e.getClass().getSimpleName(), e.getMessage(), CumulocitySeverities.CRITICAL);
        log.error("FeignException occurred", e);
        return new ResponseEntity<>(new LoraError(e.getMessage(), e.getClass().getSimpleName()),
                HttpStatus.resolve(e.status()));
    }

    @ExceptionHandler(SDKException.class)
    ResponseEntity<LoraError> processC8YSDKException(SDKException e) {
        loraContextService.error(e.getMessage(), e);
        loraContextService.sendAlarm(e.getClass().getSimpleName(), e.getMessage(), CumulocitySeverities.CRITICAL);
        log.error("SDKException occurred", e);
        return new ResponseEntity<>(new LoraError(e.getMessage(), e.getClass().getSimpleName()),
                HttpStatus.resolve(e.getHttpStatus()));
    }
}
