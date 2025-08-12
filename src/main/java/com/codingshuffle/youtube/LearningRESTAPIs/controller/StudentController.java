package com.codingshuffle.youtube.LearningRESTAPIs.controller;


import com.codingshuffle.youtube.LearningRESTAPIs.dto.StudentDto;
import com.codingshuffle.youtube.LearningRESTAPIs.entity.Student;
import com.codingshuffle.youtube.LearningRESTAPIs.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
 
    @GetMapping(path = "/student")
    public List<Student> getStudent(){
        System.out.println("database data : " + studentRepository.findAll() );
        return studentRepository.findAll();
    }

}
