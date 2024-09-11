
package com.bliss.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bliss.www.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
	Application findByUsernameAndPassword(String username, String password);
    List<Application> findByVacatedFromHostel(String vacatedFromHostel);

}
