package com.bliss.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bliss.www.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
