package com.example.cgn221springstudent.repository;

import com.example.cgn221springstudent.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentRepo {

    private final Map<String, Student> students = new HashMap<>();

    public Student addStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student getById(String id) {
        return students.get(id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student removeStudent(String id) {
        return students.remove(id);
    }

    public Student updateStudent(Student student) {
        return students.put(student.getId(), student);
    }
}
