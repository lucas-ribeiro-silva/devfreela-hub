package com.devfreelahub.services;

import com.devfreelahub.entities.Project;
import com.devfreelahub.entities.User;

public class ProjectService {

    public void createProject(User user, Project project) {
        if (project.getTitle() == null || project.getTitle().trim().isEmpty()) {
            System.out.println("Erro: O título do projeto não pode ser vazio.");
            return;
        }

        if (project.getTotalCost() <= 0) {
            System.out.println("Erro: O custo do projeto deve ser maior que zero.");
            return;
        }

        // Se passar nas validações, adiciona o projeto à lista do usuário
        user.addProject(project);
        System.out.println("Projeto '" + project.getTitle() + "' criado e associado ao usuário '" + user.getName() + "'.");
    }
}