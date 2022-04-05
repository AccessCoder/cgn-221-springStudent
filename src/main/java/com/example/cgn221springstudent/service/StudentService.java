package com.example.cgn221springstudent.service;

import com.example.cgn221springstudent.repository.StudentRepo;
import com.example.cgn221springstudent.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public Student getStudentById(String id) {
        return repo.getById(id);
    }

    public Student addStudent(Student student) {
        return repo.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }

    public Student deleteStudent(String id) {
        return repo.removeStudent(id);
    }

    public Student updateStudent(Student student) {
        return repo.updateStudent(student);
    }

    public List<Student> getStudentByName(String name) {
        List<Student> allStudents = repo.getAllStudents();

        List<Student> studentsWithName = new ArrayList<>();

        for (Student currentStudent: allStudents) {
            if (currentStudent.getName().equals(name)) {
                studentsWithName.add(currentStudent);
            }
        }

        return studentsWithName;
    }

}


