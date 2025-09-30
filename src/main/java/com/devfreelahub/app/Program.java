package com.devfreelahub.app;

import com.devfreelahub.entities.Project;
import com.devfreelahub.entities.Skill;
import com.devfreelahub.entities.User;
import com.devfreelahub.services.ProjectService;
import com.devfreelahub.services.UserService;

public class Program {

    public static void main(String[] args) {
        System.out.println("--- DevFreela Hub v2.0 ---");

        // Instanciando os serviços
        UserService userService = new UserService();
        ProjectService projectService = new ProjectService();

        // --- Etapa 1: Criação do Usuário (Cliente) ---
        System.out.println("\n[ETAPA 1] Criando um novo cliente...");
        User cliente = new User("Empresa de Software SA", "contato@softsa.com", "senhaForte");
        userService.createUser(cliente);

        // --- Etapa 2: Cliente cria um novo projeto ---
        System.out.println("\n[ETAPA 2] Cliente '" + cliente.getName() + "' está criando um projeto...");
        Project novoProjeto = new Project(
                "Desenvolvimento de E-commerce",
                "Plataforma completa de vendas online com carrinho e pagamento.",
                25000.00
        );
        projectService.createProject(cliente, novoProjeto);

        // --- Etapa 3: Adicionando habilidades necessárias ao projeto ---
        System.out.println("\n[ETAPA 3] Adicionando habilidades requeridas ao projeto '" + novoProjeto.getTitle() + "'...");
        Skill skillJava = new Skill("Java 17");
        Skill skillSpring = new Skill("Spring Boot 3");
        Skill skillDocker = new Skill("Docker");

        novoProjeto.addRequiredSkill(skillJava);
        novoProjeto.addRequiredSkill(skillSpring);
        novoProjeto.addRequiredSkill(skillDocker);
        System.out.println("Habilidades adicionadas!");

        // --- Etapa 4: Exibindo o resumo completo ---
        System.out.println("\n--- RESUMO GERAL ---");
        System.out.println("Cliente: " + cliente.getName());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Total de projetos do cliente: " + cliente.getProjects().size());

        // Usando um laço 'for-each' para percorrer a lista de projetos do cliente
        for (Project proj : cliente.getProjects()) {
            System.out.println("\n  -> Projeto: " + proj.getTitle());
            System.out.println("     Descrição: " + proj.getDescription());
            System.out.println("     Custo: R$" + proj.getTotalCost());
            System.out.println("     Habilidades Requeridas (" + proj.getRequiredSkills().size() + "):");

            // Usando outro 'for-each' para percorrer a lista de skills do projeto
            for (Skill skill : proj.getRequiredSkills()) {
                System.out.println("       - " + skill.getDescription());
            }
        }
    }
}