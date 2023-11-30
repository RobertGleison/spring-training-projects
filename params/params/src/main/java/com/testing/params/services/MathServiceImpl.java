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

    public double sum(String a, String b) {
        try{
            double op1 = convertToDouble(a);
            double op2 = convertToDouble(b);
            return op1+op2;
        }
        catch(NumberFormatException e){
            throw new MismatchOperandsException(String.format("Enter a numeric characters. %s and %s are not compatible", a,b));
        }
    }

    public Double subtract(String a, String b) {
        try{
            double op1 = convertToDouble(a);
            double op2 = convertToDouble(b);
            return op1-op2;
        }
        catch(NumberFormatException e){
            throw new MismatchOperandsException(String.format("Enter a numeric characters. %s and %s are not compatible", a,b));

        }
    }

    public Double multiply(String a, String b) {
        try{
            double op1 = convertToDouble(a);
            double op2 = convertToDouble(b);
            return op1*op2;
        }
        catch(NumberFormatException e){
            throw new MismatchOperandsException(String.format("Enter a numeric characters. %s and %s are not compatible", a,b));

        }
    }

    public Double divide(String a, String b) {
        try{
            double op1 = convertToDouble(a);
            double op2 = convertToDouble(b);
            if(op2==0) throw new ArithmeticException();
            return op1/op2;
        }
        catch(NumberFormatException e){
            throw new MismatchOperandsException(String.format("Enter a numeric characters. %s and %s are not compatible", a,b));
        }
        catch(ArithmeticException e){
            throw new MismatchOperandsException("It is impossible divide a number by 0");
        }
    }

    private boolean isNumeric(String a) {
        if(a.equals(null)) return false;
        a = a.replaceAll(",",".");
        return a.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public double convertToDouble(String a) throws NumberFormatException{
        if(isNumeric(a)){
            return Double.parseDouble(a);
        }
        else throw new NumberFormatException();
    }
}
