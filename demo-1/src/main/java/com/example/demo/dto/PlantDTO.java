package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class PlantDTO {

    @NotBlank(message = "Plant name is required")
    private String plantname;

    @NotBlank(message = "Plant color is required")
    private String plantcolor;

    // Getters and Setters
    public String getPlantname() {
        return plantname;
    }

    public void setPlantname(String plantname) {
        this.plantname = plantname;
    }

    public String getPlantcolor() {
        return plantcolor;
    }

    public void setPlantcolor(String plantcolor) {
        this.plantcolor = plantcolor;
    }
}
