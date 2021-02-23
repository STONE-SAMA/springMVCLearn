package com.example.dao;

import com.example.beans.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
