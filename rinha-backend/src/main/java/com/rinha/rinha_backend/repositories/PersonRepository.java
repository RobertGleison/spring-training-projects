package com.rinha.rinha_backend.repositories;

import com.rinha.rinha_backend.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM tb_person " +
//                    "WHERE name LIKE %:searchTerm% OR " +
//                    "nickname LIKE %:searchTerm% OR " +
//                    "FIND_IN_SET(:searchTerm, stack) > 0")

    @Query(nativeQuery = true, value =
            "SELECT * FROM tb_person " +
                    "WHERE name LIKE %:searchTerm% OR " +
                    "nickname LIKE %:searchTerm% OR " +
                    "stack LIKE CONCAT('%', :searchTerm, '%') ")
    List<Person> findByTerm(@Param("searchTerm") String searchTerm);

    Optional<Person> findByNickname(String nickname);
}
