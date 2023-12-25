package com.rinha.rinha_backend.person;

import java.util.List;
import java.util.UUID;

public record PersonRequestDto(UUID id, String nickname, String name, String birthdate, List<String> stack) {
}
