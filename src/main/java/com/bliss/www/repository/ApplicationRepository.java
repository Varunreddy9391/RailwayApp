
package com.bliss.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bliss.www.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
    List<Application> findByVacatedFromHostel(String vacatedFromHostel);
    Application findByUsernameAndPassword(String username, String password);
	Application findByUsername(String username);
	 Application findByUsernameAndEmail(String username, String email);
	 boolean existsByUsername(String username);

}
