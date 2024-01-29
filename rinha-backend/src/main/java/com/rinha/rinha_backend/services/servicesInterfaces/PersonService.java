package com.rinha.rinha_backend.services.servicesInterfaces;

import com.rinha.rinha_backend.dtos.PersonRequestDto;
import com.rinha.rinha_backend.dtos.PersonResponseDto;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    PersonResponseDto createPerson(PersonRequestDto personRequestDto);
    PersonResponseDto getPersonById(UUID id);
    List<PersonResponseDto> getAllPersons();
    List<PersonResponseDto> searchPersonByTerm(String searchTerm);
    Long registeredPersonsCounter();
}
