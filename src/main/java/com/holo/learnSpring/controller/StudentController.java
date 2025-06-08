package com.holo.learnSpring.controller;


import com.holo.learnSpring.model.entity.StudentEntity;
import com.holo.learnSpring.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get-all")
    public List<StudentEntity> getAll() {
        return studentService.getAllStudents();
    }

    @PostMapping("/save")
    public void save(@RequestBody StudentEntity studentEntity) {
        studentService.saveStudent(studentEntity);
    }

    @GetMapping("/get-student/{id}/{code}")
    public StudentEntity getById(@PathVariable Long id, @PathVariable String code) {
        return studentService.getStudentByIdAndCode(id, code);
    }

    @PutMapping("/update")
    public void update( @RequestBody StudentEntity studentEntity) {
        studentService.updateStudent(studentEntity);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody StudentEntity studentEntity) {
        studentService.deleteStudent(studentEntity);
    }
}

