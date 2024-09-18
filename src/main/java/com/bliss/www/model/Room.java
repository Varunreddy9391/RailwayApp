package com.bliss.www.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Room-management")
@Data
public class Room {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String roomNumber;
	    private int capacity;
	    private int fee;

	    // Getters and Setters

//	    public Long getId() {
//	        return id;
//	    }
//
//	    public void setId(Long id) {
//	        this.id = id;
//	    }
//
//	    public String getRoomNumber() {
//	        return roomNumber;
//	    }
//
//	    public void setRoomNumber(String roomNumber) {
//	        this.roomNumber = roomNumber;
//	    }
//
//	    public int getCapacity() {
//	        return capacity;
//	    }
//
//	    public void setCapacity(int capacity) {
//	        this.capacity = capacity;
//	    }
}
