package com.holo.learnSpring.service.impl;


import com.holo.learnSpring.model.entity.RoomEntity;
import com.holo.learnSpring.repository.RoomRepository;
import com.holo.learnSpring.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void saveRoom(RoomEntity room) {
        roomRepository.save(room);
    }

    @Override
    public void updateRoom(RoomEntity room) {
       RoomEntity roomEntity = getRoomById(room.getId());
       roomEntity.setName(room.getName());
       roomRepository.save(roomEntity);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<RoomEntity> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public RoomEntity getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }
}
