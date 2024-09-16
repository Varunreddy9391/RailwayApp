package com.bliss.www.service;

import java.util.List;
import java.util.Optional;

import com.bliss.www.model.Room;

public interface RoomService {

	 List<Room> getAllRooms();
	    Optional<Room> getRoomById(Long id);
	    Room createRoom(Room room);
	    Room updateRoom(Long id, Room room);
	    void deleteRoom(Long id);
}
