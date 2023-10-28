package crud.application.entities.user;

import crud.application.enums.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {
}
