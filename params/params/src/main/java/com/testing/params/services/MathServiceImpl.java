package com.testing.params.services;

import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl {

    public Integer sum(int a, int b) {
        return a + b;
    }

    public Integer subtract(int a, int b) {
        return a - b;
    }


    public Integer multiply(int a, int b) {
        return a * b;
    }

    public Double divide(double a, double b) {
        return a / b;
    }


}
