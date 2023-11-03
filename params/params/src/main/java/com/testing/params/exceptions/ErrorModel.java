package com.testing.params.exceptions;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ErrorModel {
    private Instant timeStamp;
    private HttpStatus status;
    private String message;
    private String error;

    public ErrorModel() {
    }

    public ErrorModel(Instant timeStamp, HttpStatus status, String message, String error) {
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

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
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
