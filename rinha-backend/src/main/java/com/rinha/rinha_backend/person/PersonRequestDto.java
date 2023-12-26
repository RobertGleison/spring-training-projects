package com.rinha.rinha_backend.person;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record PersonRequestDto(String nickname, String name, String birthdate, Set<String> stack) {
}
