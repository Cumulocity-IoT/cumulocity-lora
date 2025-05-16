package lora.ns.exception;

import lora.exception.LoraException;

public class CannotSendDownlinkException extends LoraException {

    public CannotSendDownlinkException(String message) {
        super(message);
    }

    public CannotSendDownlinkException(String message, Throwable cause) {
        super(message, cause);
    }
}
