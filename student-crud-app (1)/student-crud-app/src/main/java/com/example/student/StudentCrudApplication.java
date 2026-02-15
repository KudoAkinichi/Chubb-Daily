package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCrudApplication.class, args);
        System.out.println("🚀 Student CRUD Application Started Successfully!");
        System.out.println("📍 Access the application at: http://localhost:8080");
        System.out.println("🗄️  H2 Console available at: http://localhost:8080/h2-console");
    }
}
