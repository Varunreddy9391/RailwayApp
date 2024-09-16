package com.bliss.www.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bliss.www.model.Room;
import com.bliss.www.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
 
	private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long id, Room room) {
        if (!roomRepository.existsById(id)) {
            return null; // You might want to throw a custom exception here instead
        }
        room.setId(id);
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            // You might want to throw a custom exception here instead
            return;
        }
        roomRepository.deleteById(id);
    }
}

