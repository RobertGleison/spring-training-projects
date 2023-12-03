package com.api.controllers;

import com.api.dtos.PersonRequestDto;
import com.api.dtos.PersonResponseDto;
import com.api.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@Tag(name = "Person", description = "Endpoints to managing persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    @Operation(summary = "Finds all persons", description = "Finds all persons", tags = {"Person"}, responses = {
    @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PersonResponseDto.class)))
    }),
    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})

    public ResponseEntity<List<PersonResponseDto>> getAllPersons() {
        List<PersonResponseDto> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{personId}")
    @Operation(summary = "Finds a person", description = "Finds a person by id", tags = {"Person"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PersonResponseDto.class))}),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<PersonResponseDto> getPersonById(@PathVariable Long personId) {
        PersonResponseDto person = personService.getpersonById(personId);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    @Operation(summary = "Creates a person", description = "Creates a person by passing a Json body", tags = {"Person"}, responses = {
            @ApiResponse(description = "Created", responseCode = "200",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PersonResponseDto.class))}),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<PersonResponseDto> createPerson(@RequestBody PersonRequestDto personRequestDto) {
        PersonResponseDto createdPerson = personService.createPerson(personRequestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{personId}")
                .buildAndExpand(createdPerson.id())
                .toUri();
        return ResponseEntity.created(uri).body(createdPerson);
    }

    @PutMapping("/{personId}")
    @Operation(summary = "Updates a person", description = "Updates a person by id", tags = {"Person"}, responses = {
            @ApiResponse(description = "Updated", responseCode = "200",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PersonResponseDto.class))}),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<PersonResponseDto> updatePerson(@PathVariable Long personId, @RequestBody PersonRequestDto personRequestDto) {
        PersonResponseDto updatedPerson = personService.updatePerson(personId, personRequestDto);
        return ResponseEntity.ok(updatedPerson);
    }



    @DeleteMapping("/{personId}")
    @Operation(summary = "Deletes a person", description = "Deletes a person by id", tags = {"Person"}, responses = {
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
    public ResponseEntity<Void> deleteperson(@PathVariable Long personId) {
        personService.deletePerson(personId);
        return ResponseEntity.noContent().build();
    }
}
