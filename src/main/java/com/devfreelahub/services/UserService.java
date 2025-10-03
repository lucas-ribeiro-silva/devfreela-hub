package com.devfreelahub.services;

import com.devfreelahub.dto.UserCreateDTO;
import com.devfreelahub.dto.UserDTO;
import com.devfreelahub.entities.User;
import com.devfreelahub.repositories.UserRepository;
import com.devfreelahub.services.exceptions.DatabaseException;
import com.devfreelahub.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para o id: " + id));
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO create(UserCreateDTO dto) {
        Optional<User> existingUser = userRepository.findByEmail(dto.getEmail());
        if (existingUser.isPresent()) {
            throw new DatabaseException("O email informado já está em uso.");
        }

        User entity = new User();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));

        User savedUser = userRepository.save(entity);
        return new UserDTO(savedUser);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        User userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para o id: " + id));

        userEntity.setName(dto.getName());
        userEntity.setEmail(dto.getEmail());

        User updatedUser = userRepository.save(userEntity);
        return new UserDTO(updatedUser);
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para o id: " + id));

        // Note que adicionei a lógica de cascata na entidade User, então esta verificação manual não é mais estritamente necessária, mas mantê-la pode ser uma boa prática de negócio.
        if (!user.getProjects().isEmpty()) {
            throw new DatabaseException("Não é possível excluir um usuário que possui projetos associados.");
        }
        userRepository.deleteById(id);
    }
}