package com.example.demo.model.responses;

public class PostPlantResponse {

    private int statusCode;
    private String plantName;
    private String plantColor;

    // ✅ No-args constructor
    public PostPlantResponse() {}

    // ✅ Optional: All-args constructor (for easy creation)
    public PostPlantResponse(int statusCode, String plantName, String plantColor) {
        this.statusCode = statusCode;
        this.plantName = plantName;
        this.plantColor = plantColor;
    }

    // ✅ Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantColor() {
        return plantColor;
    }

    public void setPlantColor(String plantColor) {
        this.plantColor = plantColor;
    }
}
