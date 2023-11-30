package com.api.application.services;

import com.api.application.dtos.UserRequestDto;
import com.api.application.dtos.UserResponseDto;
import com.api.application.entities.User;
import com.api.application.exceptions.ResourceNotFoundException;
import com.api.application.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponseDto> getAllUsers() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(this::convertUserToResponseDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto getUserById(Long userId) {
        User user = findUserById(userId);
        return convertUserToResponseDto(user);
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User newUser = convertDtoToUser(userRequestDto);
        repository.save(newUser);
        return convertUserToResponseDto(newUser);
    }

    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        User existingUser = findUserById(userId);
        BeanUtils.copyProperties(userRequestDto, existingUser);
        repository.save(existingUser);
        return convertUserToResponseDto(existingUser);
    }

    public void deleteUser(Long userId) {
        User user = findUserById(userId);
        repository.delete(user);
    }

    private User findUserById(Long userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(userId));
    }

    private UserRequestDto convertUserToRequestDto(User user) {
        return new UserRequestDto(user.getName(), user.getAge(), user.getPhone(), user.getEmail());
    }

    private UserResponseDto convertUserToResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getAge(), user.getPhone(), user.getEmail());
    }

    private User convertDtoToUser(UserRequestDto userRequestDto) {
        return new User(userRequestDto.name(), userRequestDto.age(), userRequestDto.phone(), userRequestDto.email());
    }
}