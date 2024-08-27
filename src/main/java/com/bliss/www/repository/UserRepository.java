package com.bliss.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bliss.www.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	 User findByUsernameAndPassword(String username, String password);
		User findByUsername(String username);
		 User findByPhoneNumber(String phoneNumber);
		 User findByEmail(String email);
}
