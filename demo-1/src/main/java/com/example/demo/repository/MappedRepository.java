package com.example.demo.repository;

import com.example.demo.model.Mapped;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedRepository extends JpaRepository<Mapped, Integer> {
}
