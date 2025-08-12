package com.codingshuffle.youtube.LearningRESTAPIs.service;

import com.codingshuffle.youtube.LearningRESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
}
