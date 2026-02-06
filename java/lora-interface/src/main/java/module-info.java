module lora_interface {
    requires transitive java.client.model;

    requires transitive org.joda.time;
    requires transitive device.capability.model;
    requires transitive org.slf4j;
    requires transitive java.client;
    requires transitive com.fasterxml.jackson.core;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive com.fasterxml.jackson.datatype.joda;
    requires transitive microservice.subscription;
    requires transitive microservice.context;
    requires transitive spring.beans;
    requires transitive spring.web;
    requires transitive spring.core;
    requires transitive spring.context;
    requires transitive com.google.common;
    requires transitive lombok;

    exports lora.common;
    exports lora.codec;
    exports lora.codec.uplink;
    exports lora.codec.downlink;
    exports lora.ns;
    exports lora.exception;
}
