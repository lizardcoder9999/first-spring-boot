package com.spring.firstapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService _studentService;

    /*
    * The Autowired annotation is saying that the student service
    * should be injected into the constructor as a part of
    * Dependency Injection
    *
    * We also must annotate the student service class with the @Component
    * */

    @Autowired
    public StudentController(StudentService studentService){
        this._studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return _studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        _studentService.addNewStudent(student);
    }

    @DeleteMapping
    public void deleteStudent(@RequestParam Long id){
        _studentService.deleteStudent(id);
    }

    @PutMapping
    public void updateStudent(@RequestParam Long Id, @RequestParam String email, @RequestParam String name){
        _studentService.updateStudent(Id,email,name);
    }
}
