package com.testing.params.exceptions;

import java.io.Serializable;

public class MismatchOperandsException extends RuntimeException {
    public MismatchOperandsException(String message) {
        super(message);

    }
}
