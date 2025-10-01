package com.devfreelahub.controllers;

import com.devfreelahub.dto.UserDTO;
import com.devfreelahub.entities.User;
import com.devfreelahub.repositories.UserRepository;
import com.devfreelahub.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Endpoint para criar um novo usuário.
     * Verifica se o email já está em uso antes de salvar.
     */
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("O email informado já está em uso.");
        }
        User savedUser = userRepository.save(user);
        UserDTO dto = new UserDTO(savedUser);
        return ResponseEntity.ok(dto);
    }

    /**
     * Endpoint para buscar todos os usuários cadastrados.
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> dtoList = userList.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    /**
     * Endpoint para buscar um usuário específico pelo seu ID.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para o id: " + id));
        UserDTO dto = new UserDTO(user);
        return ResponseEntity.ok(dto);
    }

    /**
     * Endpoint para atualizar os dados de um usuário existente.
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO dto) {
        User userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para o id: " + id));

        userEntity.setName(dto.getName());
        userEntity.setEmail(dto.getEmail());

        User updatedUser = userRepository.save(userEntity);

        return ResponseEntity.ok(new UserDTO(updatedUser));
    }

    /**
     * Endpoint para deletar um usuário.
     * Impede a exclusão se o usuário tiver projetos associados.
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para o id: " + id));

        if (!user.getProjects().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Não é possível excluir um usuário que possui projetos associados.");
        }

        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}