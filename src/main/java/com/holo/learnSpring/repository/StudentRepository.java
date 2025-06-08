package com.holo.learnSpring.repository;

import com.holo.learnSpring.model.entity.StudentEntity;
import com.holo.learnSpring.model.entity.StudentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, StudentKey> {
}
