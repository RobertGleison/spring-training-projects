package com.api.dtos;
public record PersonRequestDto(String name,
                               Integer age,
                               String phone,
                               String email){}
