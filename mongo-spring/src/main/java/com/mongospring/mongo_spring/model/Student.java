package com.mongospring.mongo_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data                     // Lombok – getters, setters, toString, etc.
@NoArgsConstructor        // Lombok – no-arg constructor
@AllArgsConstructor       // Lombok – all-args constructor
@Document(collection = "student")  // MongoDB collection name
public class Student {

    @Id                   // Marks this field as primary key in Mongo
    private Integer rollNumber;

    private String name;
    private String address;
}
