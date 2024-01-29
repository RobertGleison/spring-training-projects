package com.rinha.rinha_backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record PersonRequestDto(@NotBlank @NotNull(message = "The nickname can not be null") String nickname,
                               @NotBlank @NotNull(message = "The name can not be null") String name, String birthdate,
                               Set<String> stack) {}
