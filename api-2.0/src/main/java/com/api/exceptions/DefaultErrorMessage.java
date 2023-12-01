package com.api.exceptions;

import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.LocalTime;

public class DefaultErrorMessage {
    private String message;
    private String error;
    private LocalTime timestamp;
    private Integer status;

    public DefaultErrorMessage(String message, String error, LocalTime timestamp, Integer status) {
        this.message = message;
        this.error = error;
        this.timestamp = timestamp;
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

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
