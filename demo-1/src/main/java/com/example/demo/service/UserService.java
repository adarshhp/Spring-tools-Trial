package com.example.demo.service;

import com.example.demo.exception.GlobalExceptionHandler;
import com.example.demo.model.Mapped;
import com.example.demo.model.Plants;
import com.example.demo.model.User;
import com.example.demo.model.responses.PostPlantResponse;
import com.example.demo.repository.MappedRepository;
import com.example.demo.repository.PlantRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Use Spring's annotation, not Jakarta's

import java.util.List;

@Service
public class UserService implements Iservice {

    private final UserRepository userRepo;
    private final MappedRepository mappedRepo;
    private final PlantRepository PlantRepo;

    public UserService(UserRepository userRepo, MappedRepository mappedRepo,PlantRepository PlantRepo) {
        this.userRepo = userRepo;
        this.mappedRepo = mappedRepo;
        this.PlantRepo = PlantRepo;
    }

    public User saveUser(User user) {
        // If there's a mapped object, link both ways
        if (user.getMapped() != null) {
            user.getMapped().setUser(user);  // set back-reference
        }
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public List<User> getUsersWithPrefixAndLength(String prefix, int length) {
        return userRepo.findUsersWithPrefixAndLength(prefix, length);
    }

    public String updateUserName(User user, int userId) {
        int updated = userRepo.updateUserName(user.getSample(), userId);
        return updated > 0 ? "Update successful" : "User not found or not updated";
    }
    @Transactional
    public Plants PostPlant(Plants plants) {
    	 Plants saved = PlantRepo.save(plants);
    	    if (plants.getPlantname().equals("error")) {
    	        throw new RuntimeException("Forcing rollback");
    	    }
    	    return saved;
    }
    public List<Plants> GetPlants(){
    	return PlantRepo.GetPlants();
    }
    @Transactional
    public String DeletePlant(int id) {
    	int Status = PlantRepo.DeletePlant(id);
    	return Status > 0 ? "Deleted successful" : "Cant Delete";
    }
    @Transactional
    public PostPlantResponse GetPlantById(int id) {
    	Plants Plant = PlantRepo.GetPlantById(id);
    	PostPlantResponse postPlantResponse=new PostPlantResponse();
    	postPlantResponse.setStatusCode(200);
    	postPlantResponse.setPlantName(Plant.getPlantname());
    	postPlantResponse.setPlantColor(Plant.getPlantcolor());
    	
    	return postPlantResponse;	
    }
}
