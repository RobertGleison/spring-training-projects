package com.testing.params.services;

import com.testing.params.exceptions.ExceptionHandlerEntity;
import com.testing.params.exceptions.MismatchOperandsException;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.InputMismatchException;
import java.util.logging.Logger;


@Service
public class MathServiceImpl {

//    private static final Logger logger = Logger.getLogger(ExceptionHandlerEntity.class.getName());

    public Integer sum(String a, String b) {
        try{
            int op1 = Integer.parseInt(a);
            int op2 = Integer.parseInt(b);
            return op1 + op2;
        }
        catch(NumberFormatException e){
            throw new MismatchOperandsException(String.format("Enter a numeric characters. %s and %s are not compatible", a,b));
        }
    }

    public Integer subtract(String a, String b) {
        try{
            int op1 = Integer.parseInt(a);
            int op2 = Integer.parseInt(b);
            return op1 - op2;
        }
        catch(NumberFormatException e){
            throw new MismatchOperandsException("Enter a valid numeric number");
        }
    }


    public Integer multiply(String a, String b) {
        try{
            int op1 = Integer.parseInt(a);
            int op2 = Integer.parseInt(b);
            return op1 * op2;
        }
        catch(NumberFormatException e){
            throw new MismatchOperandsException("Enter a valid numeric number");
        }
    }

    public Double divide(String a, String b) {
        try{
            double op1 = Double.parseDouble(a);
            double op2 = Double.parseDouble(b);
            return op1 / op2;
        }
        catch(NumberFormatException e){
            throw new MismatchOperandsException("Enter a valid numeric number");
        }
    }


}
