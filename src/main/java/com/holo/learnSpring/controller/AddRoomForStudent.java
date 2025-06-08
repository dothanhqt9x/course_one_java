package com.holo.learnSpring.controller;


import com.holo.learnSpring.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddRoomForStudent {

    private StudentService studentService;

    public AddRoomForStudent(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/add-room-for-student")
    public void add (@RequestParam Long studentId,
                     @RequestParam String studentCode,
                     @RequestParam Long roomId) {
        studentService.addRoom(studentId, studentCode, roomId);
    }
}
