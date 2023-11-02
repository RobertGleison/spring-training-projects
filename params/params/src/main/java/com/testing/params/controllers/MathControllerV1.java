package com.testing.params.controllers;

import com.testing.params.services.MathService;
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
    private MathService mathService;

    @GetMapping("/sum/{a}/{b}")
    public ResponseEntity<Integer> sum(@PathVariable(value = "a") int a, @PathVariable(value = "b") int b){
        return ResponseEntity.ok().body(mathService.sum(a,b));
    }

    @GetMapping("/subtraction/{a}/{b}")
    public ResponseEntity<Integer> subtraction(@PathVariable(value = "a") int a, @PathVariable(value = "b") int b){
        return ResponseEntity.ok().body(mathService.subtract(a,b));
    }

    @GetMapping("/multiplication/{a}/{b}")
    public ResponseEntity<Integer> multiply(@PathVariable(value = "a") int a, @PathVariable(value = "b") int b){
        return ResponseEntity.ok().body(mathService.multiply(a,b));
    }

    @GetMapping("/division/{a}/{b}")
    public ResponseEntity<Double> divide(@PathVariable(value = "a") double a, @PathVariable(value = "b") double b){
        return ResponseEntity.ok().body(mathService.divide(a,b));
    }

}
