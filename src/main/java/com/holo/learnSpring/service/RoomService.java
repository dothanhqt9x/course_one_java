package com.holo.learnSpring.service;

import com.holo.learnSpring.model.entity.RoomEntity;

import java.util.List;

public interface RoomService {

    void saveRoom(RoomEntity room);

    void updateRoom(RoomEntity room);

    void deleteRoom(Long id);

    List<RoomEntity> getAllRooms();

    RoomEntity getRoomById(Long id);
}
