package lora.ns.exception;

import lora.exception.LoraException;

public class DownlinkProcessingException extends LoraException {

    public DownlinkProcessingException(String message) {
        super(message);
    }

    public DownlinkProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

}
