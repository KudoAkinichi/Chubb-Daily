package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    // CREATE - Add a new student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    
    // READ - Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    // READ - Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    // UPDATE - Update existing student
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setCourse(studentDetails.getCourse());
        student.setAge(studentDetails.getAge());
        
        return studentRepository.save(student);
    }
    
    // DELETE - Delete student by ID
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.delete(student);
    }
    
    // SEARCH - Search students by name
    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
    
    // SEARCH - Search students by course
    public List<Student> searchStudentsByCourse(String course) {
        return studentRepository.findByCourse(course);
    }
    
    // SEARCH - General search (name, email, or course)
    public List<Student> searchStudents(String keyword) {
        return studentRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrCourseContainingIgnoreCase(
                keyword, keyword, keyword);
    }
}
