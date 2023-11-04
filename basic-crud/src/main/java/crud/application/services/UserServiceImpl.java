package crud.application.services;

import crud.application.controllers.dto.UserRequestDTO;
import crud.application.controllers.dto.UserResponseDTO;
import crud.application.entities.user.User;
import crud.application.repositories.UserRepository;
import crud.application.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService { //implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> findAll() {
        return repository.findAll().stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

    public UserResponseDTO findById(Integer id) {
        User user = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        return new UserResponseDTO(user);
//        Optional<User> user = repository.findById(id);
//        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Integer id) {
        Optional<User> user = repository.findById(id);
        if (user == null) throw new ResourceNotFoundException(id);
        else repository.deleteById(id);
    }

    public User insert(UserRequestDTO userDto) {
        User user = new User(userDto);
        UserResponseDTO userResponseDTO = new UserResponseDTO(user);
        return repository.save(user);
    }

    public UserResponseDTO update(UserRequestDTO userRequestDTO, Integer id) {
        try {
            User newUserData = new User(userRequestDTO);
            User oldUser = repository.getReferenceById(id);
            updateData(oldUser, newUserData);
            repository.save(oldUser);
            return new UserResponseDTO(oldUser);

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

    public UserResponseDTO convertUserToUserResponseDTO(User user){
        UserResponseDTO userDto = new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone());
        return userDto;

    }



//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //Spring Security use this method to consult in database a specific user
//        return repository.findByEmail(username);
    }



