package com.api.dtos;
public record UserRequestDto(String name,
                             Integer age,
                             String phone,
                             String email,
                             String password){}
