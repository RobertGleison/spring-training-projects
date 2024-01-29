package com.rinha.rinha_backend.entities.validators;

public class IsNumeric {
    public static boolean validate(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
