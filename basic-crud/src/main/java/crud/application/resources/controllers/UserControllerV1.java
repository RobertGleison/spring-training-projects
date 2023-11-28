package crud.application.resources.controllers;

import crud.application.resources.dtosV1.UserRequestDtoV1;
import crud.application.resources.dtosV1.UserResponseDtoV1;
import crud.application.entities.User;
import crud.application.services.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserControllerV1 {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDtoV1> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDtoV1>> getAllUsers() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDtoV1> updateUser(@RequestBody UserRequestDtoV1 userRequestDtoV1, @PathVariable Integer id) {
        UserResponseDtoV1 userResponseDtoV1 = service.update(userRequestDtoV1, id);
        return ResponseEntity.ok(userResponseDtoV1);
    }


    @PostMapping
    public ResponseEntity<UserResponseDtoV1> insertUser(@RequestBody UserRequestDtoV1 userDto) {
        UserResponseDtoV1 userDtoResponse = service.insert(userDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(userDtoResponse.id()).toUri();
        return ResponseEntity.created(uri).body(userDtoResponse);
    }


}
