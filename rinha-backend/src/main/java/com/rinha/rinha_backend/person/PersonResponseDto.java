package com.rinha.rinha_backend.person;

import java.util.List;

public record PersonResponseDto(String nickname, String name, String birthdate, List<String> stack) {
}
