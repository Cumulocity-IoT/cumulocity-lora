package lora.exception;

public class CannotDecodePayloadException extends LoraException {

    public CannotDecodePayloadException(String message, Exception e) {
        super(message, e);
    }

    public CannotDecodePayloadException(String message) {
        super(message);
    }

}
