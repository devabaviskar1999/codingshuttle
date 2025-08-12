package com.codingshuffle.youtube.LearningRESTAPIs.service.impl;

import com.codingshuffle.youtube.LearningRESTAPIs.dto.StudentDto;
import com.codingshuffle.youtube.LearningRESTAPIs.entity.Student;
import com.codingshuffle.youtube.LearningRESTAPIs.repository.StudentRepository;
import com.codingshuffle.youtube.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;


    public List<StudentDto> getAllStudents(){
        System.out.println("database data : " + studentRepository.findAll());
        List<StudentDto> list = studentRepository.findAll().stream().map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).toList();
        return list;
    }
    public StudentDto getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));
        return new StudentDto(student.getId(), student.getName(), student.getEmail());

    }
}
