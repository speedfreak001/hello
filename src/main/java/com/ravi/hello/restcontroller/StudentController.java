package com.ravi.hello.restcontroller;

import com.ravi.hello.entity.Student;
import com.ravi.hello.service.IStudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")//class level path
public class StudentController{
    @Autowired //to read object from container
    private IStudentService service;
    //method to save
    @ApiOperation(value = "Saving student into the table",response = Student.class)
    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student s){
        Long id = service.saveStudent(s);
        String msg="Student with id " + id + " Saved successfully";
        return ResponseEntity.ok(msg);
    }

    @ApiOperation(value = "Updating student information ",response = Student.class)
    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student s){
        service.updateStudent(s);
        String msg="Student with id " + s.getId()+ " updated successfully";
        return ResponseEntity.ok(msg);
    }

    @ApiOperation(value = "Deleting student with respect to the Id",response = Student.class)
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        service.deleteStudent(id);
        String msg="Student with id " + id + " deleted successfully";
        return ResponseEntity.ok(msg);
    }

    @ApiOperation(value = "Getting student info according to the Id given",response = Student.class)
    @GetMapping("/one/{id}")
    public ResponseEntity<Student> findOneStudent(@PathVariable("id") Long id){
        Student s=service.findStudentById(id);

        System.out.println("successfully added to git");
        return ResponseEntity.ok(s);
    }

    @ApiOperation(value = "Getting all records of the student",response = Student.class)
    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAllStudent(){
        List<Student> s=  service.findAllStudent();
//        String msg="Student with id " + id + " deleted successfully";
        return ResponseEntity.ok(s);
    }
}
