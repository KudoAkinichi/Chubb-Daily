package com.mongospring.mongo_spring.repository;

import com.mongospring.mongo_spring.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student, Integer> {
    // Student = document type
    // Integer = type of @Id (rollNumber)
}
