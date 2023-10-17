package com.rinha.rinha_backend.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoas")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(value="/{id}")
    public Person getPerson(@PathVariable Long id){
        Person person = service.findById(id);
        return person;
    }

//    @GetMapping(value="/pessoas?t=[:termo da busca]")
//    public Person getPersonbyQuery(@PathVariable String query){
//
//    }

    @GetMapping(value="/contagem-pessoas")
    public Long getPersonsCount(){
        Long count = service.getPersonsCount();
        return count;
    }



}
