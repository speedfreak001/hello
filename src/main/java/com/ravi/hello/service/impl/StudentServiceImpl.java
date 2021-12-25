package com.ravi.hello.service.impl;

import com.ravi.hello.customexception.StudentNotFindException;
import com.ravi.hello.entity.Student;
import com.ravi.hello.repository.StudentRepository;
import com.ravi.hello.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //service implementation class & mendatory
public class StudentServiceImpl implements IStudentService { //HAS a relationship

    @Autowired //to read object from container we need this annotation
    private StudentRepository repo;

    @Override
    public Long saveStudent(Student s) {
        System.out.println("Implementation class"+repo.getClass().getName());
        Student stud=repo.save(s);
        return stud.getId();
    }

    @Override
    public void updateStudent(Student s) {
        boolean exists=repo.existsById(s.getId());
        if(exists){
            repo.save(s);
        }else{
            throw new StudentNotFindException("Student with id "+s.getId()+" not found");
        }
    }
    @Override
    public void deleteStudent(Long id) {
        if(repo.existsById(id))
            repo.deleteById(id);
        else
            throw new StudentNotFindException("Student with "+ id + " not found");

    }

    @Override
    public Student findStudentById(Long id) {
            Optional<Student> op = repo.findById(id);
            if(op.isPresent()){
                return op.get();
            }
            else
                throw new StudentNotFindException("Student with "+ id + " not found");
    }

    @Override
    public List<Student> findAllStudent() {
        return repo.findAll();
    }
}
