package com.niit.mapper;

import com.niit.model.Student;

import java.util.List;

public interface StudentMapper {
    void insertStudent(Student student);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int roll_no);
    Student getStudentByRollNumber(int roll_no);
}
