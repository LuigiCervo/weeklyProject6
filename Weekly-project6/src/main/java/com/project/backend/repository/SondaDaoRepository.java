package com.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.backend.model.Sonda;

@Repository
public interface SondaDaoRepository extends JpaRepository<Sonda, Long> {
	
}
