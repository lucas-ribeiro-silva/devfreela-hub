package com.devfreelahub.entities;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String title;
    private String description;
    private double totalCost;
    private List<Skill> requiredSkills; // NOVO: Lista de habilidades necessárias

    // Construtor foi atualizado
    public Project(String title, String description, double totalCost) {
        this.title = title;
        this.description = description;
        this.totalCost = totalCost;
        this.requiredSkills = new ArrayList<>(); // NOVO: Inicializa a lista como vazia
    }

    // NOVO: Método para adicionar uma skill à lista do projeto
    public void addRequiredSkill(Skill skill) {
        this.requiredSkills.add(skill);
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    // NOVO: Getter para a lista de skills
    public List<Skill> getRequiredSkills() {
        return requiredSkills;
    }
}