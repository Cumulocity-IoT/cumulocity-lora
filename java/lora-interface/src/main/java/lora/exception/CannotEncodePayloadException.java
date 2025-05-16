package lora.exception;

public class CannotEncodePayloadException extends LoraException {

    public CannotEncodePayloadException(String message, Exception e) {
        super(message, e);
    }

    public CannotEncodePayloadException(String message) {
        super(message);
    }

}
