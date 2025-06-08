package com.holo.learnSpring.service;

import com.holo.learnSpring.model.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    List<StudentEntity> getAllStudents();

    void saveStudent(StudentEntity student);

    void updateStudent(StudentEntity student);

    void deleteStudent(StudentEntity student);

    StudentEntity getStudentByIdAndCode(Long id, String code);

    void addRoom(Long id, String code, Long roomId);
}
