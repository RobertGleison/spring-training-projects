package com.testing.params.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/calculator")
public class MathControllerV1 {

    @GetMapping("/sum/{a}/{b}")
    public ResponseEntity<Integer> sum(@PathVariable(value = "a") int a, @PathVariable(value = "b") int b){
        Integer result = a + b;
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/subtraction/{a}/{b}")
    public ResponseEntity<Integer> subtraction(@PathVariable(value = "a") int a, @PathVariable(value = "b") int b){
        Integer result = a - b;
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/multiplication/{a}/{b}")
    public ResponseEntity<Integer> multiply(@PathVariable(value = "a") int a, @PathVariable(value = "b") int b){
        Integer result = a * b;
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/division/{a}/{b}")
    public ResponseEntity<Double> divide(@PathVariable(value = "a") double a, @PathVariable(value = "b") double b){
        Double result = a / b;
        return ResponseEntity.ok().body(result);

    }

}
