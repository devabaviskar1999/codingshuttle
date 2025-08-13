package com.codingshuffle.youtube.LearningRESTAPIs.controller;


import com.codingshuffle.youtube.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.codingshuffle.youtube.LearningRESTAPIs.dto.StudentDto;
import com.codingshuffle.youtube.LearningRESTAPIs.entity.Student;
import com.codingshuffle.youtube.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    public final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent() {
       return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable("id") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
    return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
//    return ResponseEntity.created(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto){
    return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDto));
    }
}

