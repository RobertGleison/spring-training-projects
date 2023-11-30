package com.api.application.dtos;

public record UserRequestDto(String name,
                             Integer age,
                             String phone,
                             String email) {
}
