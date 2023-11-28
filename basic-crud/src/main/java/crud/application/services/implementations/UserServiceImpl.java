package crud.application.services.implementations;

import crud.application.resources.dtosV1.UserRequestDtoV1;
import crud.application.resources.dtosV1.UserResponseDtoV1;
import crud.application.entities.User;
import crud.application.repositories.UserRepository;
import crud.application.exceptions.ResourceNotFoundException;
import crud.application.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<UserResponseDtoV1> findAll() {
        return repository.findAll().stream().map(UserResponseDtoV1::new).collect(Collectors.toList());
    }

    @Override
    public UserResponseDtoV1 findById(Integer id) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new UserResponseDtoV1(user);
        //Optional<User> user = repository.findById(id);
        //return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void deleteById(Integer id) {
        Optional<User> user = repository.findById(id);
        if(user.isPresent()) repository.deleteById(id);
        else throw new ResourceNotFoundException(id);
    }

    @Override
    public UserResponseDtoV1 insert(UserRequestDtoV1 userDto) {
        User user = new User(userDto);
        return convertUserToUserResponseDTO(repository.save(user));
    }

    @Override
    public UserResponseDtoV1 update(UserRequestDtoV1 userRequestDtoV1, Integer id) {
        try {
            User newUserData = new User(userRequestDtoV1);
            User oldUser = repository.getReferenceById(id);
            updateData(oldUser, newUserData);
            repository.save(oldUser);
            return new UserResponseDtoV1(oldUser);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User oldUser, User newUser) {
        newUser.setName(oldUser.getName());
        newUser.setEmail(oldUser.getEmail());
        newUser.setPassword(oldUser.getPassword());
        newUser.setPhone(oldUser.getPhone());
    }

    public UserResponseDtoV1 convertUserToUserResponseDTO(User user) {
        return new UserResponseDtoV1(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone());

    }
}



