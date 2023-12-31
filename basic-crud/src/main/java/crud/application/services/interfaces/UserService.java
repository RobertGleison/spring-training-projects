package crud.application.services.interfaces;

import crud.application.resources.dtosV1.UserRequestDtoV1;
import crud.application.resources.dtosV1.UserResponseDtoV1;
import crud.application.entities.User;
import java.util.List;

public interface UserService {
     List<UserResponseDtoV1> findAll();
     UserResponseDtoV1 findById(Integer id);
     void deleteById(Integer id);
     UserResponseDtoV1 insert(UserRequestDtoV1 userRequestDtoV1);
     UserResponseDtoV1 update(UserRequestDtoV1 userResponseDTO, Integer id);
}
