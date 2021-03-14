package com.spring.firstapp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


/*
* Student Seeder
* */

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
          Student seedStudent1 = new Student("Mariam","mariam.jamal@gmail.com", LocalDate.of(2000, Month.JANUARY,5));
          Student seedStudent2 = new Student("John","john@gmail.com", LocalDate.of(2000, Month.JANUARY,5));
          repository.saveAll(List.of(seedStudent1,seedStudent2));
        };
    }

}
