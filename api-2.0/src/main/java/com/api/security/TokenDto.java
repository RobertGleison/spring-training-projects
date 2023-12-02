package com.api.security;

import java.time.LocalTime;

public record TokenDto(String username,
                       Boolean authenticated,
                       LocalTime created,
                       LocalTime expiration,
                       String accessToken,
                       String refreshToken) {
}
