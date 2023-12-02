package com.api.services;

import com.api.dtos.PersonRequestDto;
import com.api.dtos.PersonResponseDto;
import com.api.entities.Person;
import com.api.exceptions.ResourceNotFoundException;
import com.api.repositories.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<PersonResponseDto> getAllPersons() {
        List<Person> persons = repository.findAll();
        return persons.stream()
                .map(this::convertPersonToResponseDto)
                .collect(Collectors.toList());
    }

    public PersonResponseDto getpersonById(Long personID) {
        Person person = findPersonById(personID);
        return convertPersonToResponseDto(person);
    }

    public PersonResponseDto createPerson(PersonRequestDto personRequestDto) {
        Person newPerson = convertDtoToPerson(personRequestDto);
        repository.save(newPerson);
        return convertPersonToResponseDto(newPerson);
    }

    public PersonResponseDto updatePerson(Long userId, PersonRequestDto personRequestDto) {
        Person existingPerson = findPersonById(userId);
        BeanUtils.copyProperties(personRequestDto, existingPerson);
        repository.save(existingPerson);
        return convertPersonToResponseDto(existingPerson);
    }

    public void deletePerson(Long userId) {
        Person person = findPersonById(userId);
        repository.delete(person);
    }

    private Person findPersonById(Long userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(userId));
    }

    private PersonRequestDto convertPersonToRequestDto(Person person) {
        return new PersonRequestDto(person.getName(), person.getAge(), person.getPhone(), person.getEmail());
    }

    private PersonResponseDto convertPersonToResponseDto(Person person) {
        return new PersonResponseDto(person.getId(), person.getName(), person.getAge(), person.getPhone(), person.getEmail());
    }

    private Person convertDtoToPerson(PersonRequestDto personRequestDto) {
        return new Person(personRequestDto.name(), personRequestDto.age(), personRequestDto.phone(), personRequestDto.email());
    }
}