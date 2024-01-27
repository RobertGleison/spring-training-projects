package com.rinha.rinha_backend.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record PersonRequestDto(@NotNull(message = "The nickname can not be null") @NotBlank String nickname,@NotNull(message = "The name can not be null") @NotBlank String name, String birthdate, Set<String> stack) {
}
