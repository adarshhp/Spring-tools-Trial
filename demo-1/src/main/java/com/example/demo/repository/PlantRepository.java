package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Plants;



public interface PlantRepository extends JpaRepository<Plants, Integer> {
	
	@Query("SELECT u FROM Plants u where u.is_deleted=0")
    public List<Plants> GetPlants();
	
	@Modifying
    @Query("Update Plants p set p.is_deleted = 1 WHERE p.id = :id")
	int DeletePlant(@Param("id") int id);
	
	@Query("SELECT u FROM Plants u where u.is_deleted = 0 AND u.id = :id")
	Plants GetPlantById(@Param("id") int id);
}
