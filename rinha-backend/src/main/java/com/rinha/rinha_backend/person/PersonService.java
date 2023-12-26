package com.rinha.rinha_backend.person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    PersonResponseDto createPerson(PersonRequestDto personRequestDto);
    PersonResponseDto getPersonById(UUID id);
    List<PersonResponseDto> getAllPersons();
    PersonResponseDto searchPersonByTerm(String searchTerm);
    Long registeredPersonsCounter();
}
