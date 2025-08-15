package com.codingshuffle.youtube.LearningRESTAPIs.service.impl;

import com.codingshuffle.youtube.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.codingshuffle.youtube.LearningRESTAPIs.dto.StudentDto;
import com.codingshuffle.youtube.LearningRESTAPIs.entity.Student;
import com.codingshuffle.youtube.LearningRESTAPIs.repository.StudentRepository;
import com.codingshuffle.youtube.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<StudentDto> getAllStudents() {
        System.out.println("database data : " + studentRepository.findAll());
        List<StudentDto> list = studentRepository.findAll().stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
        return list;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student does not exists by id : " + id);
        } else {
            studentRepository.deleteById(id);
        }
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));
        modelMapper.map(addStudentRequestDto, student); //so first field is assigning to second one, means it modifying the existing field
        Student student1 = studentRepository.save(student); //so we're saving the modified student instance
        return modelMapper.map(student1, StudentDto.class); //now we're converting it to dto(means what we want to send to user)
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));
        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported!");

            }
        });
          Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
