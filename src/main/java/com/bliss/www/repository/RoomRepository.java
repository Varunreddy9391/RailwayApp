package com.bliss.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bliss.www.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
