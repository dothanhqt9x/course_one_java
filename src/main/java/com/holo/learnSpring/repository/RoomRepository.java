package com.holo.learnSpring.repository;

import com.holo.learnSpring.model.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
}
