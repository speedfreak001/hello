package com.ravi.hello.service;

import com.ravi.hello.entity.Student;

import java.util.List;
//API

public interface IStudentService {
//CRUD operations
    Long saveStudent(Student s);
    void updateStudent(Student s);
    void deleteStudent(Long id);
    Student findStudentById(Long id);
    List<Student> findAllStudent();
}
