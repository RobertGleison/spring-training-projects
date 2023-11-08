package crud.application.resources.dtosV1;

import crud.application.entities.User;

public record UserResponseDtoV1(Integer id, String name, String email, String phone) {
    public UserResponseDtoV1(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }
}

