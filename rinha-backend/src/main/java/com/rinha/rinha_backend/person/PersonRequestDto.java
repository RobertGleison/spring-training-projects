package com.rinha.rinha_backend.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record PersonRequestDto(@NotNull @NotBlank String nickname,@NotNull @NotBlank String name, String birthdate, Set<String> stack) {
}
