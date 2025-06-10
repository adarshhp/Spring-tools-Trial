package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Plants;
import com.example.demo.model.User;
import com.example.demo.model.responses.PostPlantResponse;

public interface Iservice {
    User saveUser(User user);
    List<User> getAllUsers();
    List<User> getUsersWithPrefixAndLength(String prefix, int length);
    String updateUserName(User user, int userId);
    Plants PostPlant(Plants plants);
    List<Plants> GetPlants();
    String DeletePlant(int id);
    PostPlantResponse GetPlantById(int id);
}
