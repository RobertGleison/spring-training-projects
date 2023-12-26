package com.rinha.rinha_backend.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import java.util.NoSuchElementException;
import java.util.UUID;

public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public PersonResponseDto createPerson(PersonRequestDto personRequestDto) {
        Person person = convertPersonRequestDtoToPerson(personRequestDto);
        return new PersonResponseDto(repository.save(person));
    }

    @Override
    public PersonResponseDto getPersonById(UUID id) {
        return new PersonResponseDto(repository.findById(id).orElseThrow(() -> new NoSuchElementException("This person is not registered")));
    }

    @Override
    public PersonResponseDto searchPersonByTerm(String searchTerm) {
        return null;
    }

    @Override
    public Long registeredPersonsCounter() {
        return repository.count();

    }

    private Person convertPersonRequestDtoToPerson(PersonRequestDto personRequestDto) {
        return new Person(
                personRequestDto.nickname(),
                personRequestDto.name(),
                personRequestDto.birthdate(),
                personRequestDto.stack());
    }
}
