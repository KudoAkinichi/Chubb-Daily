package com.example.student.repository;

import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Custom query methods for search functionality
    
    // Search by name (case-insensitive, partial match)
    List<Student> findByNameContainingIgnoreCase(String name);
    
    // Search by email
    Optional<Student> findByEmail(String email);
    
    // Search by course
    List<Student> findByCourse(String course);
    
    // Search by name or email or course
    List<Student> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrCourseContainingIgnoreCase(
            String name, String email, String course);
}
