package com.bliss.www.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="api/image")
public class Image {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_seq")
	    @SequenceGenerator(name = "app_seq", sequenceName = "app_sequence", allocationSize = 1, initialValue = 1)
    private Long id;
    
    private String name;
    private String contentType;
    
    // Image 1 fields
    private byte[] data1;
    private String name1;
    private String contentType1;
    
    // Image 2 fields
    private byte[] data2;
    private String name2;
    private String contentType2;
    
    private String role;

    // Getters and Setters
}
