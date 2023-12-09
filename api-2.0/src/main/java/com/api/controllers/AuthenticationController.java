package com.api.controllers;//package com.api.controllers;
//
//import com.api.dtos.AuthenticationDto;
//import com.api.dtos.LoginResponseDto;
//import com.api.dtos.RegisterDto;
//import com.api.entities.User;
//import com.api.repositories.UserRepository;
//import com.api.securityInfrastructure.TokenService;
import com.api.dtos.AuthenticationDto;
import com.api.dtos.LoginResponseDto;
import com.api.dtos.RegisterDto;
import com.api.entities.User;
import com.api.repositories.UserRepository;
import com.api.securityInfrastructure.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private static final Logger logger = Logger.getLogger(AuthenticationController.class.getName());
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDto data) {
        logger.info("Enter the login controller");
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        logger.info("Created usernamePassword");
        var auth = this.authenticationManager.authenticate(usernamePassword);
        logger.info("Created auth");
        var token = tokenService.generateToken((User) auth.getPrincipal());
        logger.info("Created token");
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDto data) {
        logger.info("Enter the register controller");
        if (this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        logger.info("User do not exist in database");
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);
        logger.info("Saved new user in the database");
        return ResponseEntity.ok().build();
    }
}