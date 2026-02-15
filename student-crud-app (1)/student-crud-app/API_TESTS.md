# API Testing Examples
# You can use these with Postman, curl, or any REST client

## 1. Add Student (POST)
curl -X POST http://localhost:8080/api/students \
-H "Content-Type: application/json" \
-d '{
  "name": "Virat Kohli",
  "email": "virat@example.com",
  "course": "Sports Management",
  "age": 23
}'

## 2. Get All Students (GET)
curl -X GET http://localhost:8080/api/students

## 3. Get Student by ID (GET)
curl -X GET http://localhost:8080/api/students/1

## 4. Update Student (PUT)
curl -X PUT http://localhost:8080/api/students/1 \
-H "Content-Type: application/json" \
-d '{
  "name": "Virat Kohli Updated",
  "email": "virat.updated@example.com",
  "course": "Sports Management Advanced",
  "age": 24
}'

## 5. Delete Student (DELETE)
curl -X DELETE http://localhost:8080/api/students/1

## 6. Search Students (GET)
curl -X GET "http://localhost:8080/api/students/search?keyword=virat"

## 7. Search by Name (GET)
curl -X GET "http://localhost:8080/api/students/search/name?name=kohli"

## 8. Search by Course (GET)
curl -X GET "http://localhost:8080/api/students/search/course?course=sports"

---

# Testing Sequence (Copy-paste in terminal after app starts)

# 1. Add first student
curl -X POST http://localhost:8080/api/students -H "Content-Type: application/json" -d '{"name": "Raj Kumar", "email": "raj@example.com", "course": "Computer Science", "age": 21}'

# 2. Add second student
curl -X POST http://localhost:8080/api/students -H "Content-Type: application/json" -d '{"name": "Priya Sharma", "email": "priya@example.com", "course": "Mechanical", "age": 20}'

# 3. Add third student
curl -X POST http://localhost:8080/api/students -H "Content-Type: application/json" -d '{"name": "Amit Patel", "email": "amit@example.com", "course": "Computer Science", "age": 22}'

# 4. View all students
curl -X GET http://localhost:8080/api/students

# 5. Search for "computer"
curl -X GET "http://localhost:8080/api/students/search?keyword=computer"

# 6. Update student with ID 1
curl -X PUT http://localhost:8080/api/students/1 -H "Content-Type: application/json" -d '{"name": "Raj Kumar Singh", "email": "raj.singh@example.com", "course": "Computer Science Engineering", "age": 21}'

# 7. Delete student with ID 2
curl -X DELETE http://localhost:8080/api/students/2

# 8. View remaining students
curl -X GET http://localhost:8080/api/students
