package com.api.services;

import com.api.dtos.PersonRequestDto;
import com.api.dtos.PersonResponseDto;
import com.api.entities.Person;
import com.api.entities.User;
import com.api.exceptions.ResourceNotFoundException;
import com.api.repositories.PersonRepository;
import com.api.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    private User findUserById(Long userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(userId));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = repository.findByUsername(username);
        if(user!=null) return user;
        else throw new UsernameNotFoundException("Username " + username + " not found.");
    }
}