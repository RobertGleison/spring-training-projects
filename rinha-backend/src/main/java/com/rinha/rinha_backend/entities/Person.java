package com.rinha.rinha_backend.entities;

import com.rinha.rinha_backend.entities.validators.IsNumeric;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @NotBlank
    @Length(max = 32)
    private String nickname;
    @NotNull
    @NotBlank
    @Length(max = 100)
    private String name;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])-(0[1-9]|1[0-2])-(\\d{4})$",
            message = "The birthday must follow dd-mm-yyyy structure")
    private String birthdate;
    //    @Pattern(regexp = "[a-zA-Z]+")
    private Set<String> stack = new HashSet<>();

    public Person() {
    }

    public Person(String nickname, String name, String birthdate, Set<String> stack) {
        this.nickname = nickname;
        if (!IsNumeric.validate(name)) this.name = name;
        else throw new IllegalArgumentException("Name can not be numbers");
        this.birthdate = birthdate;
        for (String s : stack) addStack(s);
    }

    public UUID getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Set<String> getStack() {
        return stack;
    }

    public void addStack(String stack) {
        if (IsNumeric.validate(stack)) throw new IllegalArgumentException("Stacks can not be numbers");
        if (stack.length() > 32) throw new IllegalArgumentException("Stacks must have 32 max length");
        this.stack.add(stack);
    }

    public void removeStack(String stack) {
        if (this.stack.contains(stack)) this.stack.remove(stack);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", stacks=" + stack +
                '}';
    }
}
