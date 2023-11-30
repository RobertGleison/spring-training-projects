package com.api.controllers;

import com.api.model.Dtos.PersonDto;
import com.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public List<PersonDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public PersonDto create(@RequestBody PersonDto person) {
        return service.create(person);
    }

    @PutMapping("/{id}")
    public PersonDto update(@RequestBody PersonDto person, @PathVariable Long id) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}