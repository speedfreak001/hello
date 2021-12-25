package com.ravi.hello.repository;

import com.ravi.hello.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.studName=:name")
    Student exist(String name);

}
