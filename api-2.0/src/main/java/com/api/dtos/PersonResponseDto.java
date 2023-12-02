package com.api.dtos;

public record PersonResponseDto(Long id, String name,
                                Integer age,
                                String phone,
                                String email) {
}
