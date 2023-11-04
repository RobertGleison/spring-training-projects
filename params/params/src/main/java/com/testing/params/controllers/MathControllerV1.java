package com.testing.params.controllers;

import com.testing.params.services.MathServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/calculator")
public class MathControllerV1 {

    @Autowired
    private MathServiceImpl mathServiceImpl;

    @GetMapping("/sum/{a}/{b}")
    public ResponseEntity<Integer> sum(@PathVariable(value = "a") String a, @PathVariable(value = "b") String b){
        return ResponseEntity.ok().body(mathServiceImpl.sum(a,b));
    }

    @GetMapping("/subtraction/{a}/{b}")
    public ResponseEntity<Integer> subtraction(@PathVariable(value = "a") String a, @PathVariable(value = "b") String b){
        return ResponseEntity.ok().body(mathServiceImpl.subtract(a,b));
    }

    @GetMapping("/multiplication/{a}/{b}")
    public ResponseEntity<Integer> multiply(@PathVariable(value = "a") String a, @PathVariable(value = "b") String b){
        return ResponseEntity.ok().body(mathServiceImpl.multiply(a,b));
    }

    @GetMapping("/division/{a}/{b}")
    public ResponseEntity<Double> divide(@PathVariable(value = "a") String a, @PathVariable(value = "b") String b){
        return ResponseEntity.ok().body(mathServiceImpl.divide(a,b));
    }

}
