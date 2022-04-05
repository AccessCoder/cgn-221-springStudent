package com.example.cgn221springstudent.service;

import com.example.cgn221springstudent.model.Student;
import com.example.cgn221springstudent.repository.StudentRepo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    private StudentRepo studentRepo = mock(StudentRepo.class);
    private StudentService studentService = new StudentService(studentRepo);

    @Test
    void getStudentById_whenId1_thenReturnStudentWithId1() {
        //GIVEN
        when(studentRepo.getById("1")).thenReturn(new Student("Florian", "1"));

        //WHEN
        Student actual = studentService.getStudentById("1");

        //THEN
        Student expected = new Student("Florian", "1");

        verify(studentRepo).getById("1");
        assertEquals(expected, actual);
    }

    @Test
    void deleteStudent_whenId2_thenReturnDeletedStudent() {
        //GIVEN
        when(studentRepo.removeStudent("2")).thenReturn(new Student("Deleted Student", "2"));

        //WHEN
        Student actual = studentService.deleteStudent("2");

        //THEN
        Student expected = new Student("Deleted Student", "2");


        verify(studentRepo).removeStudent("2");
        assertEquals(expected, actual);
    }

    @Test
    void getStudentByName() {
        //GIVEN
        when(studentRepo.getAllStudents()).thenReturn(List.of(new Student("Florian", "1"), new Student("Matthias", "2")));

        //WHEN
        List<Student> actual = studentService.getStudentByName("Matthias");

        //THEN
        List<Student> expected = List.of(new Student("Matthias", "2"));

        verify(studentRepo).getAllStudents();
        assertEquals(expected, actual);
    }

    @Test
    void getStudentByName_whenFlorian_thenReturnFlorian() {
        //GIVEN
        when(studentRepo.getAllStudents()).thenReturn(List.of(new Student("Florian", "1"), new Student("Matthias", "2")));

        //WHEN
        List<Student> actual = studentService.getStudentByName("Florian");

        //THEN
        List<Student> expected = List.of(new Student("Florian", "1"));

        verify(studentRepo).getAllStudents();
        assertEquals(expected, actual);
    }
}
