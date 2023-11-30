package com.api.application.exceptions;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable {
    public static final long serialUID = 1L;
    public ResourceNotFoundException(Long id){
        super("Resource with id = " + id +" not found in database. ");
    }
}
