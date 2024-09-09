package com.bliss.www.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="varun1")
public class User 
{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
