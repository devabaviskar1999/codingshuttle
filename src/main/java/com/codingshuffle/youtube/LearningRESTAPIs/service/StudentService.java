package com.codingshuffle.youtube.LearningRESTAPIs.service;

import com.codingshuffle.youtube.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.codingshuffle.youtube.LearningRESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);
    void deleteStudentById(Long id);
    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto );
}
