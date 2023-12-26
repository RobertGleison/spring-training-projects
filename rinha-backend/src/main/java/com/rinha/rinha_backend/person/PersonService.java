package com.rinha.rinha_backend.person;

import java.util.UUID;

public interface PersonService {
    PersonResponseDto createPerson(PersonRequestDto personRequestDto);
    PersonResponseDto getPersonById(UUID id);
    PersonResponseDto searchPersonByTerm(String searchTerm);
    Long registeredPersonsCounter();
}
