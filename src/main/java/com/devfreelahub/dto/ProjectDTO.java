package com.devfreelahub.dto;

import com.devfreelahub.entities.Project;

public class ProjectDTO {
    private Long id;
    private String title;
    private String description;
    private double totalCost;
    private Long ownerId; // O campo existe, mas faltam os métodos de acesso

    public ProjectDTO() {}

    public ProjectDTO(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.totalCost = entity.getTotalCost();
        // This line requires getOwner() on the Project entity and getId() on the User entity
        if (entity.getOwner() != null) {
            this.ownerId = entity.getOwner().getId();
        }
    }

    // --- Getters e Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    // ✅ MÉTODOS QUE ESTAVAM FALTANDO
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}