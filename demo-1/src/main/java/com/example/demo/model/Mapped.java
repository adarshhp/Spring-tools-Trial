package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "mapped_table")
public class Mapped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String column_data;
    private String column_data2;

    @OneToOne(mappedBy = "mapped")  // this must match the field name in User
    @JsonBackReference   // Add this
    private User user;

    // === Getters and Setters ===

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumn_data() {
        return column_data;
    }

    public void setColumn_data(String column_data) {
        this.column_data = column_data;
    }

    public String getColumn_data2() {
        return column_data2;
    }

    public void setColumn_data2(String column_data2) {
        this.column_data2 = column_data2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
