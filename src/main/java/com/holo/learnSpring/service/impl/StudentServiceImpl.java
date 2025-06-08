package com.holo.learnSpring.service.impl;

import com.holo.learnSpring.model.entity.RoomEntity;
import com.holo.learnSpring.model.entity.StudentEntity;
import com.holo.learnSpring.model.entity.StudentKey;
import com.holo.learnSpring.repository.RoomRepository;
import com.holo.learnSpring.repository.StudentRepository;
import com.holo.learnSpring.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final RoomRepository roomRepository;


    public StudentServiceImpl(StudentRepository studentRepository, RoomRepository roomRepository) {
        this.studentRepository = studentRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return students;
    }

    @Override
    public void saveStudent(StudentEntity student) {
        studentRepository.save(student);
    }

    @Override
    public StudentEntity getStudentByIdAndCode(Long id, String code) {
        StudentKey key = new StudentKey();
        key.setId(id);
        key.setCode(code);

        return studentRepository.findById(key)
                .orElseThrow(() -> new RuntimeException("ko tim thay student"));
    }

    @Override
    public void addRoom(Long id, String code, Long roomId) {
        StudentEntity studentEntity = getStudentByIdAndCode(id, code);
        RoomEntity roomEntity = roomRepository.getReferenceById(roomId);

        Set<RoomEntity> rooms = studentEntity.getRooms();
        rooms.add(roomEntity);
        studentEntity.setRooms(rooms);
        studentRepository.save(studentEntity);
    }

    @Override
    public void updateStudent(StudentEntity student) {
            StudentEntity studentEntity = getStudentByIdAndCode(student.getStudentKey().getId(), student.getStudentKey().getCode());
            studentEntity.setName(student.getName());
            studentEntity.setAge(student.getAge());
            studentRepository.save(studentEntity);
    }

    @Override
    public void deleteStudent(StudentEntity student) {
        studentRepository.delete(student);
    }

}
