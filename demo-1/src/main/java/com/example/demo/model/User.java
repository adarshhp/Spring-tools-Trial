package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "javademotable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sample;
    
    @OneToOne(cascade = CascadeType.ALL)  // propagate changes
    @JoinColumn(name = "mapped_id")       // foreign key column in javademotable table
    @JsonBackReference   // Add this
    private Mapped mapped;

    // ✅ Getter and Setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // ✅ Getter and Setter for sample
    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }
    
    public Mapped getMapped() { return mapped; }  // ✅ this is what was missing
    public void setMapped(Mapped mapped) { this.mapped = mapped; }
}
