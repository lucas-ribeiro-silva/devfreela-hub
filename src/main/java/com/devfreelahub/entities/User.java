package com.devfreelahub.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // <-- ADICIONADO: Define esta classe como uma tabela no banco
@Table(name = "tb_user") // <-- ADICIONADO: Define o nome da tabela
public class User {

    @Id // <-- ADICIONADO: Marca o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <-- ADICIONADO: O banco vai gerar o ID
    private Long id;

    private String name;
    private String email;
    private String password;

    // A anotação @OneToMany define a relação: Um Usuário para Muitos Projetos.
    // "mappedBy" indica que a relação é gerenciada pelo campo "owner" na classe Project.
    @OneToMany(mappedBy = "owner")
    private List<Project> projects = new ArrayList<>();

    // O JPA exige um construtor padrão (sem argumentos)
    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // --- Getters e Setters ---
    // (Getters e setters para todos os campos, incluindo o novo 'id')

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}