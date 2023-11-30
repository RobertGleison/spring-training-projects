package com.api.application.controllers;

import com.api.application.dtos.UserRequestDto;
import com.api.application.dtos.UserResponseDto;
import com.api.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId) {
        UserResponseDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto createdUser = userService.createUser(userRequestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(createdUser.id())
                .toUri();
        return ResponseEntity.created(uri).body(createdUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto updatedUser = userService.updateUser(userId, userRequestDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
