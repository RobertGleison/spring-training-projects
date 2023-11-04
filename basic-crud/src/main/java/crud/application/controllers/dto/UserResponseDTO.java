package crud.application.controllers.dto;

import crud.application.entities.user.User;

public record UserResponseDTO(Integer id, String name, String email, String phone) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }
}

