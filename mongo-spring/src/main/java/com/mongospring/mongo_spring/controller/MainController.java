package com.mongospring.mongo_spring.controller;

import com.mongospring.mongo_spring.model.Student;
import com.mongospring.mongo_spring.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private StudentRepo studentRepo;

    // ----------------- POST: Add student -----------------
    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        studentRepo.save(student);
    }

    // ----------------- GET: Fetch all students -----------------
    @GetMapping("/fetchStudents")
    public List<Student> fetchStudents() {
        return studentRepo.findAll();
    }

    // ----------------- GET: Fetch student by ID -----------------
    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentRepo.findById(id).orElse(null);
    }

    // ----------------- PUT: Update student -----------------
    @PutMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student) {
        // 1. Fetch old data using rollNumber (ID)
        Student data = studentRepo.findById(student.getRollNumber()).orElse(null);

        if (data != null) {
            // 2. Update fields
            data.setName(student.getName());
            data.setAddress(student.getAddress());

            // 3. Save updated object back to DB
            studentRepo.save(data);
        }
        // If data == null, nothing happens (could also return 404 in real apps)
    }

    // ----------------- DELETE: Delete student by ID -----------------
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepo.deleteById(id);
    }
}
