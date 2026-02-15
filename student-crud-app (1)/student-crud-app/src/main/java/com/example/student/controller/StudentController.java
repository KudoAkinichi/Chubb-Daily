package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*") // Allow requests from any origin (for testing)
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    // CREATE - Add new student
    // POST: http://localhost:8080/api/students
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    
    // READ - Get all students
    // GET: http://localhost:8080/api/students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    // READ - Get student by ID
    // GET: http://localhost:8080/api/students/1
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // UPDATE - Update student
    // PUT: http://localhost:8080/api/students/1
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        try {
            Student updatedStudent = studentService.updateStudent(id, studentDetails);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // DELETE - Delete student
    // DELETE: http://localhost:8080/api/students/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // SEARCH - Search students by keyword
    // GET: http://localhost:8080/api/students/search?keyword=john
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam String keyword) {
        List<Student> students = studentService.searchStudents(keyword);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    // SEARCH - Search by name
    // GET: http://localhost:8080/api/students/search/name?name=john
    @GetMapping("/search/name")
    public ResponseEntity<List<Student>> searchByName(@RequestParam String name) {
        List<Student> students = studentService.searchStudentsByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    // SEARCH - Search by course
    // GET: http://localhost:8080/api/students/search/course?course=computer
    @GetMapping("/search/course")
    public ResponseEntity<List<Student>> searchByCourse(@RequestParam String course) {
        List<Student> students = studentService.searchStudentsByCourse(course);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
