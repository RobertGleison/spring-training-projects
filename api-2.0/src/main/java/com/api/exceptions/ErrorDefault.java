package com.api.exceptions;

import java.io.Serializable;
import java.time.LocalTime;

public class ErrorDefault implements Serializable {

    private static final long serialVersionUID = 1L;

    private final LocalTime timestamp;
    private final String message;
    private final String details;

    public ErrorDefault(LocalTime timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}