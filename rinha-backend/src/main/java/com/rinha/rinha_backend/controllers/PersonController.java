package com.rinha.rinha_backend.controllers;

import com.rinha.rinha_backend.dtos.PersonRequestDto;
import com.rinha.rinha_backend.dtos.PersonResponseDto;
import com.rinha.rinha_backend.services.servicesInterfaces.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/pessoas")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> getAllPerson(@RequestParam(name = "t", required = false) String searchTerm) {
        if (searchTerm != null && !searchTerm.isEmpty()) return ResponseEntity.ok().body(service.searchPersonByTerm(searchTerm));
        return ResponseEntity.ok().body(service.getAllPersons());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDto> getPerson(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.getPersonById(id));
    }

    @GetMapping(value = "/contagem-pessoas")
    public ResponseEntity<Long> getPersonsCount() {
        return ResponseEntity.ok().body(service.registeredPersonsCounter());
    }

    @PostMapping
    public ResponseEntity<PersonResponseDto> createPerson(@Valid @RequestBody PersonRequestDto personRequestDto){
        PersonResponseDto personResponseDto = service.createPerson(personRequestDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + personResponseDto.id())
                .build()
                .toUri();
        return ResponseEntity.created(uri).body(personResponseDto);
    }
}
