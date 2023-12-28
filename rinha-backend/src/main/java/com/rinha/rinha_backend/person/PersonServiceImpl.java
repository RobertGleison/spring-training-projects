package com.rinha.rinha_backend.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public PersonResponseDto createPerson(PersonRequestDto personRequestDto) {
        Optional<Person> existingPerson = repository.findByNickname(personRequestDto.nickname());
        if(existingPerson.isPresent()) throw new RuntimeException("This person is already registered");
        Person person = convertPersonRequestDtoToPerson(personRequestDto);
        return convertPersonToResponseDto(repository.save(person));
    }

    @Override
    public PersonResponseDto getPersonById(UUID id) {
        return convertPersonToResponseDto(repository.findById(id).orElseThrow(() -> new NoSuchElementException("This person is not registered")));
    }

    @Override
    public List<PersonResponseDto> getAllPersons() {
        return repository.findAll().stream().map(this::convertPersonToResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<PersonResponseDto> searchPersonByTerm(String searchTerm) {
        return repository.findByTerm(searchTerm).stream().map(this::convertPersonToResponseDto).collect(Collectors.toList());
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

    private PersonResponseDto convertPersonToResponseDto(Person person) {
        return new PersonResponseDto(
                person.getId(),
                person.getNickname(),
                person.getName(),
                person.getBirthdate(),
                person.getStack());
    }
}
