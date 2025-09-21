package com.live.kafka.stream.exception;

public class ProducerException extends RuntimeException {

    public ProducerException(String message) {
        super(message);
    }

    public ProducerException(String message, Throwable cause) {
        super(message, cause);
    }
}
