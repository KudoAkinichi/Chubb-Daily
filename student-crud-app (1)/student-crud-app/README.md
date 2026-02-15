# Student CRUD Application - Spring Boot

A simple CRUD (Create, Read, Update, Delete) application built with Spring Boot for learning purposes.

## Features

- ✅ Add new students
- ✅ View all students
- ✅ Update student information
- ✅ Delete students
- ✅ Search students by name, email, or course

## Technologies Used

- **Spring Boot 3.2.0** - Framework
- **Spring Data JPA** - Database operations
- **H2 Database** - In-memory database
- **Lombok** - Reduce boilerplate code
- **Maven** - Build tool

## Project Structure

```
student-crud-app/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/student/
│       │       ├── StudentCrudApplication.java (Main class)
│       │       ├── controller/
│       │       │   └── StudentController.java (REST endpoints)
│       │       ├── model/
│       │       │   └── Student.java (Entity)
│       │       ├── repository/
│       │       │   └── StudentRepository.java (Database operations)
│       │       └── service/
│       │           └── StudentService.java (Business logic)
│       └── resources/
│           └── application.properties (Configuration)
└── pom.xml (Maven dependencies)
```

## How to Run

### Prerequisites
- Java 17 or higher
- Maven installed

### Steps

1. **Navigate to project directory:**
   ```bash
   cd student-crud-app
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Application will start at:**
   - API: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console

## API Endpoints

### 1. CREATE - Add New Student
```
POST http://localhost:8080/api/students
Content-Type: application/json

{
  "name": "Rahul Sharma",
  "email": "rahul@example.com",
  "course": "Computer Science",
  "age": 20
}
```

### 2. READ - Get All Students
```
GET http://localhost:8080/api/students
```

### 3. READ - Get Student by ID
```
GET http://localhost:8080/api/students/1
```

### 4. UPDATE - Update Student
```
PUT http://localhost:8080/api/students/1
Content-Type: application/json

{
  "name": "Rahul Kumar Sharma",
  "email": "rahul.sharma@example.com",
  "course": "Computer Science Engineering",
  "age": 21
}
```

### 5. DELETE - Delete Student
```
DELETE http://localhost:8080/api/students/1
```

### 6. SEARCH - Search Students
```
GET http://localhost:8080/api/students/search?keyword=rahul
GET http://localhost:8080/api/students/search/name?name=rahul
GET http://localhost:8080/api/students/search/course?course=computer
```

## Testing with Postman or Browser

### Using Postman:
1. Download Postman from https://www.postman.com/
2. Create requests using the endpoints above
3. Set appropriate HTTP methods (GET, POST, PUT, DELETE)
4. For POST/PUT, add JSON body

### Using Browser (for GET requests):
- View all: http://localhost:8080/api/students
- Search: http://localhost:8080/api/students/search?keyword=computer

## H2 Database Console

Access the database directly:
1. Go to: http://localhost:8080/h2-console
2. Use these settings:
   - JDBC URL: `jdbc:h2:mem:studentdb`
   - Username: `sa`
   - Password: (leave blank)
3. Click "Connect"

## Sample Test Data

Add these students using POST requests:

```json
{
  "name": "Amit Kumar",
  "email": "amit@example.com",
  "course": "Computer Science",
  "age": 21
}
```

```json
{
  "name": "Priya Singh",
  "email": "priya@example.com",
  "course": "Mechanical Engineering",
  "age": 20
}
```

```json
{
  "name": "Rohit Verma",
  "email": "rohit@example.com",
  "course": "Electrical Engineering",
  "age": 22
}
```

## Learning Points

1. **@RestController** - Handles HTTP requests
2. **@Service** - Business logic layer
3. **@Repository** - Database access layer
4. **@Entity** - JPA entity mapping
5. **JpaRepository** - Provides CRUD methods automatically
6. **HTTP Methods:**
   - POST - Create
   - GET - Read
   - PUT - Update
   - DELETE - Delete

## Common Issues & Solutions

**Issue: Port 8080 already in use**
- Solution: Change port in application.properties: `server.port=8081`

**Issue: Lombok not working**
- Solution: Enable annotation processing in your IDE

**Issue: Database not persisting data**
- Solution: H2 is in-memory; data is lost when app stops. This is normal for learning!

## Next Steps to Enhance

1. Add input validation (@Valid, @NotNull)
2. Add exception handling (custom exceptions)
3. Add pagination and sorting
4. Switch to MySQL/PostgreSQL
5. Add Spring Security
6. Create a frontend (React/Angular/Thymeleaf)

Happy Learning! 🚀
