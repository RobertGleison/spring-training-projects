package com.api.dtos;

import com.api.enums.UserRole;

public record RegisterDto(String login, String password, UserRole role) {
}
