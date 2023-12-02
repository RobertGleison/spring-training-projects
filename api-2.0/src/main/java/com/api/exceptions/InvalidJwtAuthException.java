package com.api.exceptions;

import javax.naming.AuthenticationException;
import java.io.Serializable;

public class InvalidJwtAuthException extends AuthenticationException implements Serializable {
    public static final long serialUID = 1L;
    public InvalidJwtAuthException(String ex){
        super(ex);
    }
}
