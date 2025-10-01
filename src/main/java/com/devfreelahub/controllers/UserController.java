package com.devfreelahub.controllers;

import com.devfreelahub.entities.User;
import com.devfreelahub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Anotação que define esta classe como um Controller REST
@RequestMapping(value = "/users") // Todas as requisições para "/users" virão para esta classe
public class UserController {

    @Autowired // O Spring vai injetar uma instância do UserRepository automaticamente
    private UserRepository userRepository;

    @PostMapping // Este método vai responder a requisições HTTP POST para "/users"
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}