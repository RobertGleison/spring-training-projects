package com.rinha.rinha_backend.person;

import com.rinha.rinha_backend.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
