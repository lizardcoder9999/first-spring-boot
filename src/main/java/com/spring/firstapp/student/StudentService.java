package com.spring.firstapp.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/*
* We annotate this as service since we annotated it with autowired in the student controller.
* */

@Service
public class StudentService {

    private final StudentRepository _studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this._studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return _studentRepository.findAll();
    }

    public void addNewStudent(Student student){
       Optional<Student> studentWithEmail = _studentRepository.findStudentByEmail(student.getEmail());
       if (studentWithEmail.isPresent()){
           throw new IllegalStateException("email taken");
       }else{
           _studentRepository.save(student);
       }
    }

    public void deleteStudent(Long id) {
        Optional<Student> studentById = _studentRepository.findStudentById(id);
        if(!studentById.isPresent()){
            throw new IllegalStateException("User does not exist");
        }else{
            _studentRepository.deleteById(id);
        }
    }

    public void updateStudent(Long Id,String email,String name) {
       Student previousStudent = _studentRepository.getOne(Id);
       previousStudent.setName(name);
       previousStudent.setEmail(email);
       _studentRepository.save(previousStudent);
    }
}
