package com.api.dtos;

public record UserResponseDto(Long id, String name,
                              Integer age,
                              String phone,
                              String email) {
}
