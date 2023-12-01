package com.api.services;

import com.api.dtos.UserRequestDto;
import com.api.dtos.UserResponseDto;
import com.api.entities.User;
import com.api.exceptions.ResourceNotFoundException;
import com.api.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock //Create mock of repository
    private UserRepository repository;

    @InjectMocks //Inject repository mock in service
    private UserService userService;

    @Test
    @DisplayName("Should return a list of users if they exists")
    void testGetAllUsers() {
        // Set the behavior of mock
        when(repository.findAll()).thenReturn(Arrays.asList(new User(), new User()));

        // Act
        List<UserResponseDto> result = userService.getAllUsers();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Should return an user if user exists")
    void testGetUserByIdSucceded() {
        // Arrange
        long userId = 1L;
        User user = new User();
        user.setId(userId);
        when(repository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        UserResponseDto result = userService.getUserById(userId);

        // Assert
        assertEquals(userId, result.getId());
    }

    @Test
    @DisplayName("Should not return an user if it do not exists")
    void testGetUserById_ThrowsExceptionWhenUserNotFound() {
        // Arrange
        long userId = 1L;
        when(repository.findById(userId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> userService.getUserById(userId));
    }

    @Test
    void testCreateUser() {
        // Arrange
        UserRequestDto userRequestDto = new UserRequestDto("John Doe", 30, "1234567890", "john@example.com");
        when(repository.save(any(User.class))).thenReturn(new User());

        // Act
        UserResponseDto result = userService.createUser(userRequestDto);

        // Assert
        // Add assertions based on your business logic or DTO conversion
    }

    @Test
    void testUpdateUser() {
        // Arrange
        long userId = 1L;
        UserRequestDto userRequestDto = new UserRequestDto("Updated User", 25, "9876543210", "updated@example.com");
        User existingUser = new User();
        existingUser.setId(userId);
        when(repository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(repository.save(any(User.class))).thenReturn(existingUser);

        // Act
        UserResponseDto result = userService.updateUser(userId, userRequestDto);

        // Assert
        // Add assertions based on your business logic or DTO conversion
    }

    @Test
    void testUpdateUser_ThrowsExceptionWhenUserNotFound() {
        // Arrange
        long userId = 1L;
        when(repository.findById(userId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> userService.updateUser(userId, new UserRequestDto()));
    }

    @Test
    @DisplayName("Should delete an user if it exists in database")
    void testDeleteUserSucceded() {
        // Arrange
        long userId = 1L;
        User user = new User();
        when(repository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        userService.deleteUser(userId);

        // Assert
        verify(repository, times(1)).delete(user);
    }

    @Test
    void testDeleteUser_ThrowsExceptionWhenUserNotFound() {
        // Arrange
        long userId = 1L;
        when(repository.findById(userId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> userService.deleteUser(userId));
    }
}