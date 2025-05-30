package lora.ns.exception;

import lora.exception.LoraException;

public class DeviceNotFoundException extends LoraException {

    public DeviceNotFoundException(String deviceEUI) {
        super("Device identified by EUI " + deviceEUI + " does not exist.");
    }

}
