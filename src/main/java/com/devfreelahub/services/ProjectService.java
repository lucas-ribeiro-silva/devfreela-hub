package com.devfreelahub.services;

import com.devfreelahub.dto.ProjectDTO;
import com.devfreelahub.entities.Project;
import com.devfreelahub.entities.User;
import com.devfreelahub.repositories.ProjectRepository;
import com.devfreelahub.repositories.UserRepository;
import com.devfreelahub.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<ProjectDTO> findAll() {
        List<Project> projectList = projectRepository.findAll();
        return projectList.stream().map(ProjectDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProjectDTO findById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado para o id: " + id));
        return new ProjectDTO(project);
    }

    @Transactional
    public ProjectDTO create(ProjectDTO dto) {
        User owner = userRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário proprietário não encontrado para o id: " + dto.getOwnerId()));

        Project entity = new Project();
        copyDtoToEntity(dto, entity);
        entity.setOwner(owner);

        Project savedProject = projectRepository.save(entity);
        return new ProjectDTO(savedProject);
    }

    @Transactional
    public ProjectDTO update(Long id, ProjectDTO dto) {
        Project entity = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado para o id: " + id));

        copyDtoToEntity(dto, entity);

        Project updatedProject = projectRepository.save(entity);
        return new ProjectDTO(updatedProject);
    }

    @Transactional
    public void delete(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Projeto não encontrado para o id: " + id);
        }
        projectRepository.deleteById(id);
    }

    // Método auxiliar para copiar dados do DTO para a entidade
    private void copyDtoToEntity(ProjectDTO dto, Project entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setTotalCost(dto.getTotalCost());
    }
}