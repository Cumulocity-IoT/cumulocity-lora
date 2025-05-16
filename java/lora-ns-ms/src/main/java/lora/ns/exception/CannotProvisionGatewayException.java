package lora.ns.exception;

import lora.exception.LoraException;

public class CannotProvisionGatewayException extends LoraException {

    public CannotProvisionGatewayException(String message) {
        super(message);
    }

    public CannotProvisionGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
