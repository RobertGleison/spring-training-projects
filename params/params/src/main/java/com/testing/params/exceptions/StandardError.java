package com.testing.params.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    private Instant timeStamp;
    private String status;
    private String message;
    private String error;

    public StandardError() {
    }

    public StandardError(Instant timeStamp, String status, String message, String error) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
