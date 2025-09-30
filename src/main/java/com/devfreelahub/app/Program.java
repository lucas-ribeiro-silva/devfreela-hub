package com.devfreelahub.app;

import com.devfreelahub.entities.Project;
import com.devfreelahub.entities.User;
import com.devfreelahub.services.UserService;

public class Program {

    public static void main(String[] args) {
        System.out.println("--- Iniciando DevFreela Hub ---");

        // Instanciando o nosso serviço
        UserService userService = new UserService();

        // Cenário 1: Criando um usuário com sucesso (simulando o CT01)
        System.out.println("\nCenário 1: Tentativa de criar usuário válido");
        User user1 = new User("Vinicius Junior", "vini@email.com", "123456");
        userService.createUser(user1);

        // Cenário 2: Tentando criar um usuário com nome vazio (simulando o CT02)
        System.out.println("\nCenário 2: Tentativa de criar usuário com nome vazio");
        User user2 = new User("", "neymar@email.com", "123456");
        userService.createUser(user2);

        // Cenário 3: Tentando criar um usuário com email vazio
        System.out.println("\nCenário 3: Tentativa de criar usuário com email vazio");
        User user3 = new User("Rodrygo Goes", "", "123456");
        userService.createUser(user3);

        // Instanciando outros objetos para ver a estrutura funcionando
        System.out.println("\n--- Outras Entidades ---");
        Project project1 = new Project("Criação de API REST", "API para sistema de e-commerce", 5000.0);
        System.out.println("Projeto criado: " + project1.getTitle() + " | Custo: R$" + project1.getTotalCost());
    }
}