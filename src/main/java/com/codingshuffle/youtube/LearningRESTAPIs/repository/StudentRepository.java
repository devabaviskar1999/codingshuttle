package com.codingshuffle.youtube.LearningRESTAPIs.repository;

import com.codingshuffle.youtube.LearningRESTAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
