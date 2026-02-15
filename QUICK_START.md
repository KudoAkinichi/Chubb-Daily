# 🚀 QUICK START GUIDE - Student CRUD Application

## Step 1: Download the Project
Download the `student-crud-app.zip` file and extract it to your desired location.

## Step 2: Open in IDE
- **IntelliJ IDEA**: File → Open → Select the `student-crud-app` folder
- **Eclipse**: File → Import → Existing Maven Projects → Select the folder
- **VS Code**: Open the folder directly

## Step 3: Run the Application

### Option A: Using IDE
1. Open `StudentCrudApplication.java`
2. Right-click on the file
3. Select "Run" or "Run StudentCrudApplication"

### Option B: Using Terminal/Command Prompt
```bash
cd student-crud-app
mvn spring-boot:run
```

## Step 4: Test the Application

### Using Browser (Simple GET requests):
Open browser and visit:
- View all students: http://localhost:8080/api/students
- Search students: http://localhost:8080/api/students/search?keyword=raj

### Using Postman (All CRUD operations):

1. **Add Student (POST):**
   - URL: http://localhost:8080/api/students
   - Method: POST
   - Body (JSON):
   ```json
   {
     "name": "Rahul Sharma",
     "email": "rahul@example.com",
     "course": "Computer Science",
     "age": 21
   }
   ```

2. **View All Students (GET):**
   - URL: http://localhost:8080/api/students
   - Method: GET

3. **Update Student (PUT):**
   - URL: http://localhost:8080/api/students/1
   - Method: PUT
   - Body (JSON):
   ```json
   {
     "name": "Rahul Kumar",
     "email": "rahul.updated@example.com",
     "course": "CSE",
     "age": 22
   }
   ```

4. **Delete Student (DELETE):**
   - URL: http://localhost:8080/api/students/1
   - Method: DELETE

5. **Search (GET):**
   - URL: http://localhost:8080/api/students/search?keyword=computer
   - Method: GET

## Step 5: View Database (Optional)
1. Open: http://localhost:8080/h2-console
2. Enter:
   - JDBC URL: `jdbc:h2:mem:studentdb`
   - Username: `sa`
   - Password: (leave empty)
3. Click "Connect"

## 📂 Project Structure Explained

```
student-crud-app/
├── pom.xml                          # Maven dependencies
├── src/main/java/com/example/student/
│   ├── StudentCrudApplication.java  # Main class (START HERE)
│   ├── controller/
│   │   └── StudentController.java   # REST API endpoints
│   ├── service/
│   │   └── StudentService.java      # Business logic
│   ├── repository/
│   │   └── StudentRepository.java   # Database operations
│   └── model/
│       └── Student.java             # Student entity
└── src/main/resources/
    └── application.properties       # Configuration
```

## 🎯 What Each Layer Does

1. **Controller**: Receives HTTP requests and sends responses
2. **Service**: Contains business logic and rules
3. **Repository**: Talks to the database
4. **Model**: Defines the Student structure

## ✅ Success Indicators

When application starts successfully, you'll see:
```
🚀 Student CRUD Application Started Successfully!
📍 Access the application at: http://localhost:8080
🗄️  H2 Console available at: http://localhost:8080/h2-console
```

## 🔧 Troubleshooting

**Problem: Port 8080 already in use**
Solution: Change port in `application.properties`:
```properties
server.port=8081
```

**Problem: Maven dependencies not downloading**
Solution: Run `mvn clean install` in terminal

**Problem: Lombok annotations not working**
Solution: Enable annotation processing in IDE settings

## 📚 Learn More

Read the full `README.md` file for:
- Detailed API documentation
- More testing examples
- Enhancement ideas
- Learning resources

Happy Coding! 🎉
