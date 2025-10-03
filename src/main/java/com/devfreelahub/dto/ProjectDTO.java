package com.devfreelahub.dto;

import com.devfreelahub.entities.Project;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProjectDTO {
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String title;

    @NotBlank(message = "A descrição é obrigatória")
    private String description;

    @Positive(message = "O custo total deve ser um valor positivo")
    private double totalCost;

    @NotNull(message = "O ID do proprietário é obrigatório")
    private Long ownerId;

    public ProjectDTO() {}

    public ProjectDTO(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.totalCost = entity.getTotalCost();
        if (entity.getOwner() != null) {
            this.ownerId = entity.getOwner().getId();
        }
    }

    // --- Getters e Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}