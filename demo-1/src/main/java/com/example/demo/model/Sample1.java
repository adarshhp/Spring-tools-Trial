package com.example.demo.model;

import java.time.LocalDateTime;

public class Sample1 {

	    private Long id;
	    private String name;
	    private String email;
	    private LocalDateTime createdAt;

	    // Constructors
	    public Sample1() {}

	    public Sample1(Long id, String name, String email, LocalDateTime createdAt) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.createdAt = createdAt;
	    }

	    // Getters and Setters
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

	    public LocalDateTime getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(LocalDateTime createdAt) {
	        this.createdAt = createdAt;
	    }

	    // toString method
	    @Override
	    public String toString() {
	        return "User{" +
	               "id=" + id +
	               ", name='" + name + '\'' +
	               ", email='" + email + '\'' +
	               ", createdAt=" + createdAt +
	               '}';
	    }
	}



