package com.devfreelahub.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    // Mapeamento inverso (opcional, mas bom para navegação)
    @ManyToMany(mappedBy = "requiredSkills")
    private Set<Project> projects = new HashSet<>();

    // Construtor padrão
    public Skill() {
    }

    public Skill(String description) {
        this.description = description;
    }

    // --- Getters e Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Project> getProjects() {
        return projects;
    }
}