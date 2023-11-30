package com.api.model.Dtos;

public record PersonDto(Long id,
                        String firstName,
                        String lastName,
                        String address,
                        String gender) {
}
