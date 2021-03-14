package com.spring.firstapp.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/*
* When making a JPA repository we make a interface extending JpaRepository
* The JpaRepository takes 2 generic parameters,
* one for are model, and one for the primary key
* we must annotate it with Repository
* */

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //Spring Data Jpa is convention based and automatically constructs queries
    Optional<Student> findStudentByEmail(String email);
    Optional<Student> findStudentById(Long Id);
}
