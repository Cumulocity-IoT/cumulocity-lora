package lora.ns.exception;

import lora.exception.LoraException;

public class UplinkProcessingException extends LoraException {

    public UplinkProcessingException(String message) {
        super(message);
    }

    public UplinkProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

}
