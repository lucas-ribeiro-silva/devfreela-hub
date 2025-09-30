package com.devfreelahub.services;

import com.devfreelahub.entities.User;

public class UserService {

    // Método que contém a lógica para criar um usuário
    public void createUser(User user) {
        // Validação simples (o desafio de lógica com if/else)
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            System.out.println("Erro: O nome do usuário não pode ser vazio.");
            return; // Encerra a execução do método
        }

        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            System.out.println("Erro: O email do usuário não pode ser vazio.");
            return; // Encerra a execução do método
        }

        // Se passar pelas validações, o usuário é "criado"
        System.out.println("Usuário '" + user.getName() + "' criado com sucesso!");
    }
}