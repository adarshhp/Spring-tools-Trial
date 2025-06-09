package com.example.demo.controller;

import com.example.demo.dto.PlantDTO;
import com.example.demo.model.Plants;
import com.example.demo.model.User;
import com.example.demo.model.responses.PostPlantResponse;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;
    
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.saveUser(user); // handles Mapped inside
    }

    @GetMapping()
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/filter")
    public List<User> getFilteredUsers(
            @RequestParam(defaultValue = "A") String prefix,
            @RequestParam(defaultValue = "7") int length) {
        return service.getUsersWithPrefixAndLength(prefix, length);
    }

    @PostMapping("/updateUser")
    public String updateUserName(@RequestBody User user, @RequestParam int userId) {
        return service.updateUserName(user, userId);
    }
    
    @PostMapping("/postplant")
    public ResponseEntity<?> postPlant(@Valid @RequestBody PlantDTO plantDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();
            return ResponseEntity.badRequest().body(errors);
        }else {
        // Convert DTO to Entity
        Plants plant = new Plants();
        plant.setPlantname(plantDTO.getPlantname());
        plant.setPlantcolor(plantDTO.getPlantcolor());

        Plants savedPlant = service.PostPlant(plant);
        return ResponseEntity.ok(savedPlant);
        }
    }

    
    @GetMapping("/getplant")
    public List<Plants> GetPlants(){
    	return service.GetPlants();
    }
    
    @PostMapping("deleteplant")
    public String DeletePlant(@RequestParam int id) {
    	return service.DeletePlant(id);
    }
    @PostMapping("getplantById")
    public PostPlantResponse GetPlantById(@RequestParam int id) {
    	return service.GetPlantById(id);
    }

}



