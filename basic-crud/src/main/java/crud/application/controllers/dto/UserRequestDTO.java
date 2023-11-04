package crud.application.controllers.dto;

import crud.application.entities.user.User;

public record UserRequestDTO(Integer id, String name, String email, String phone, String password) {
}
