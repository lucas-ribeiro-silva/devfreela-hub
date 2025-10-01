package com.devfreelahub.dto;

import com.devfreelahub.entities.User;

public class UserDTO {
    private Long id;
    private String name;
    private String email;

    // Construtor padrão
    public UserDTO() {
    }

    // Construtor que converte uma Entidade User em um UserDTO
    public UserDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}