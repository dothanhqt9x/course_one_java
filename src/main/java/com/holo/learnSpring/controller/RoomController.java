package com.holo.learnSpring.controller;


import com.holo.learnSpring.model.entity.RoomEntity;
import com.holo.learnSpring.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    private final RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/get-all-room")
    public List<RoomEntity> getAllRoom() {
        return roomService.getAllRooms();
    }

    @GetMapping("/get-room/{id}")
    public RoomEntity getRoom(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping("/add-room")
    public void addRoom(@RequestBody RoomEntity room) {
        roomService.saveRoom(room);
    }

    @PutMapping("/update-room")
    public void updateRoom(@RequestBody RoomEntity room) {
        roomService.updateRoom(room);
    }

    @DeleteMapping("/delete-room/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

}

