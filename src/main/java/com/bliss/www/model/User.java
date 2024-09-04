package com.bliss.www.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="api/loginsignup/table")
@Data
public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_seq")
	    @SequenceGenerator(name = "app_seq", sequenceName = "app_sequence", allocationSize = 1, initialValue = 1)
	    private Long id;
	     
	    @Column
	    private String username;
	    @Column
	    private String phoneNumber;
	    @Column
	    private String email;
	    @Column
	    private String password;
	    @Column
	    private String role;
	    @Column
	    private String currentPassword;
}
