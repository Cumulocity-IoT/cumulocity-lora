package lora.ns.exception;

import lora.exception.LoraException;

public class CannotCreateRouteException extends LoraException {

    public CannotCreateRouteException(String message) {
        super(message);
    }

    public CannotCreateRouteException(String message, Throwable cause) {
        super(message, cause);
    }

}
