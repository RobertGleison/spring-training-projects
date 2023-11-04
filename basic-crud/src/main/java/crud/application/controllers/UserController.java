package crud.application.controllers;

import crud.application.controllers.dto.UserRequestDTO;
import crud.application.controllers.dto.UserResponseDTO;
import crud.application.entities.user.User;
import crud.application.services.UserServiceImpl;
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
    private UserServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserRequestDTO userRequestDTO, @PathVariable Integer id){
        UserResponseDTO userResponseDTO = service.update(userRequestDTO,id);
        return ResponseEntity.ok(userResponseDTO);
    }

//Returning an ResponseDTO for security of information
    @PostMapping
    public ResponseEntity<UserResponseDTO> insertUser(@RequestBody UserRequestDTO userDto){
        User user = service.insert(userDto);
        UserResponseDTO userResponseDto = new UserResponseDTO(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(userResponseDto);
    }








}
