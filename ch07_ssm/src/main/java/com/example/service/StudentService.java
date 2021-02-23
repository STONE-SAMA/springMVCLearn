package com.example.service;

import com.example.beans.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student> findStudents();
}
