package com.testing.params.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MathService {

    public Integer sum(int a,int b){
        return a+b;
    }

    public Integer multiply(int a,int b){
        return a*b;
    }

    public Double divide(double a,double b){
        return a/b;
    }

    public Integer subtract(int a,int b){
        return a-b;
    }


}
