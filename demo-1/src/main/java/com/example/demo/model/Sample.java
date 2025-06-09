package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "plants")
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "plant_name", nullable = false)
    private String name;

    @Column(name = "plant_color")
    private String color;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int isDeleted = 0;

    // --- Getters and Setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
