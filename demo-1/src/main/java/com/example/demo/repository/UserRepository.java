package com.example.demo.repository;
import java.util.List;
import com.example.demo.model.User;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Optional: Custom queries go here
	
	@Query("SELECT u FROM User u WHERE u.sample LIKE :prefix% AND LENGTH(u.sample) > :length")
	List<User> findUsersWithPrefixAndLength(@Param("prefix") String prefix, @Param("length") int length);

	@Modifying
    @Transactional
    @Query("UPDATE User u SET u.sample = :newSample WHERE u.id = :userId")
    int updateUserName(@Param("newSample") String newSample,@Param("userId") Integer userId);
	
	
	
}
