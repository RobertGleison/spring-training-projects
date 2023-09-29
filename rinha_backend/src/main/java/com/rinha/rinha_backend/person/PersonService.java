package com.rinha.rinha_backend.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public void insertPerson(Person person) {
        repository.save(person);
    }

    public Person findById(Long id) {
        Optional<Person> person = repository.findById(id);
        return person.orElse(null);
    }

    public List<Person> findAll(){
        List<Person> list = repository.findAll();
        return list;
    }

    public Long getPersonsCount() {
        List<Person> list = findAll();
        Long count = list.stream().filter(x->x!=null).count();
        return count;
    }


}
