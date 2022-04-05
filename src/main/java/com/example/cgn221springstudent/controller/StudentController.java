package com.example.cgn221springstudent.controller;


import com.example.cgn221springstudent.model.Student;
import com.example.cgn221springstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return List.of(new Student("Berta", "7112"), new Student("Paul", "4711"));
    }

    @GetMapping(path = "{id}") //localhost:8080/student/0000
    public Student getStudentById(@PathVariable String id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @GetMapping("allstudents")
    public List<Collection<Student>> listAllStudents() {
        return service.getAllStudents();
    }

    @DeleteMapping(path = "{id}")
    public Student deleteStudent(@PathVariable String id) {
        return service.deleteStudent(id);

    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }



}
