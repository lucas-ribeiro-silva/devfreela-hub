package com.devfreelahub.app;

import com.devfreelahub.entities.Project;
import com.devfreelahub.entities.User;
import com.devfreelahub.services.ProjectService;
import com.devfreelahub.services.UserService;

public class Program {

    public static void main(String[] args) {
        System.out.println("--- Iniciando DevFreela Hub ---");

        // --- Services ---
        UserService userService = new UserService();
        ProjectService projectService = new ProjectService();

        // --- Create a User first ---
        User cliente = new User("Empresa de Software SA", "contato@softsa.com", "senhaForte");
        userService.createUser(cliente);

        // --- Now, create a Project and pass the User as the owner ---
        System.out.println("\nCliente '" + cliente.getName() + "' está criando um projeto...");

        // Corrected line: Pass the 'cliente' object as the fourth argument
        Project novoProjeto = new Project(
                "Desenvolvimento de E-commerce",
                "Plataforma completa de vendas online.",
                25000.00,
                cliente // Pass the owner object here
        );

        projectService.createProject(cliente, novoProjeto);

        System.out.println("\nProjeto criado: " + novoProjeto.getTitle());
    }
}