package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Application;

 
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	Optional<Application> findByUsername(String username);
	 
}
