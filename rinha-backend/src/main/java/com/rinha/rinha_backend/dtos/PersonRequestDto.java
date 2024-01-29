package com.rinha.rinha_backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record PersonRequestDto(@NotBlank @NotNull(message = "The nickname can not be null") String nickname,
                               @NotBlank @NotNull(message = "The name can not be null") String name,
                               @Pattern(regexp = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])-(0[1-9]|1[0-2])-(\\d{4})$",
                                        message = "The birthday must follow dd-mm-yyyy structure") String birthdate,
                               Set<String> stack) {}
