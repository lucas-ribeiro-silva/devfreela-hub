package com.devfreelahub.entities;

public class Project {

    private String title;
    private String description;
    private double totalCost;

    public Project(String title, String description, double totalCost) {
        this.title = title;
        this.description = description;
        this.totalCost = totalCost;
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
}