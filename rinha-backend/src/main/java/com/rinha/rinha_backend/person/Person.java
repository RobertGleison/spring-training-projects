package com.rinha.rinha_backend.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="tb_person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @NotBlank
    @Length(max=32)
    private String nickname;
    @NotNull
    @NotBlank
    @Length(max=100)
    private String name;
    @NotNull
    @NotBlank
    private String birthdate;
    private Set<String> stack = new HashSet<>();

    public Person() {
    }

    public Person(String nickname, String name, String birthdate, Set<String> stack) {
        this.nickname = nickname;
        if(!isNumeric(name)) this.name = name;
        else throw new IllegalArgumentException("Name can not be numbers");
        this.birthdate = birthdate;
        this.stack = stack;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Set<String> getStack() {
        return stack;
    }

    public void addStack(String stack){
        if(isNumeric(stack)) throw new IllegalArgumentException("Stacks can not be numbers");
        if(stack.length() > 32) throw new IllegalArgumentException("Stacks must have 32 max length");
        this.stack.add(stack);
    }

    public void removeStack(String stack){
        if(this.stack.contains(stack)) this.stack.remove(stack);
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

    private boolean isNumeric(String input) {
        try{
            Integer.parseInt(input);
            Double.parseDouble(input);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
