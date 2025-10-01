package com.devfreelahub.controllers;

import com.devfreelahub.dto.ProjectDTO;
import com.devfreelahub.entities.Project;
import com.devfreelahub.entities.User;
import com.devfreelahub.repositories.ProjectRepository;
import com.devfreelahub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO dto) {
        // Busca o usuário dono do projeto no banco
        User owner = userRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Dono do projeto não encontrado!"));

        // Cria a entidade Project a partir do DTO
        Project newProject = new Project(dto.getTitle(), dto.getDescription(), dto.getTotalCost(), owner);

        // Salva o novo projeto no banco
        Project savedProject = projectRepository.save(newProject);

        // Retorna o DTO do projeto salvo
        return ResponseEntity.ok(new ProjectDTO(savedProject));
    }
}