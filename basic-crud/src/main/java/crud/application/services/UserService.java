package crud.application.services;

import crud.application.controllers.dto.UserRequestDTO;
import crud.application.controllers.dto.UserResponseDTO;
import crud.application.entities.user.User;

import java.util.List;

public interface UserService {
     List<UserResponseDTO> findAll();
     UserResponseDTO findById(Integer id);
     void deleteById(Integer id);
     User insert(UserRequestDTO userRequestDTO);
     UserResponseDTO update(UserRequestDTO userResponseDTO, Integer id);
}
