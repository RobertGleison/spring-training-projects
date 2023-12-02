package com.api.security;

import com.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository repository;

    public ResponseEntity signin(AccountCredentialsDto data){
        try {
            var username = data.username();
            var password = data.password();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            var user = repository.findByUsername(username);
            var token = new TokenDto();
            if(){
                token = tokenProvider.createAccessToken(username, user.getRoles());
            }
            else throw new UserPrincipalNotFoundException("Username not found.")
            return ResponseEntity.ok();
        }
        catch(Exception e){
            throw new BadCredentialsException("Invalid password.");
    }

}
