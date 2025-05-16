package lora.ns.exception;

import lora.exception.LoraException;

public class ConnectorDoesNotExistException extends LoraException {

    public ConnectorDoesNotExistException(String loraConnectorId) {
        super("LoRa connector with ID " + loraConnectorId + " does not exist");
    }

}
