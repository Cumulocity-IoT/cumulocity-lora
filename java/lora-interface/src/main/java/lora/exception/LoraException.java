package lora.exception;

public class LoraException extends RuntimeException {

    public LoraException(String message) {
        super(message);
    }

    public LoraException(String message, Throwable cause) {
        super(message, cause);
    }
}
