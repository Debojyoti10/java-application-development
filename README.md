# LMS Employee Backend

This is a Spring Boot application for managing employee data in an LMS system.

## Prerequisites
- Java 17
- Maven
- PostgreSQL

## Setup
1. Create a database named `LMS` in PostgreSQL.
2. Update `src/main/resources/application.properties` with your PostgreSQL credentials if different from default.
3. Run `mvn spring-boot:run` to start the application.

## API Endpoints
- POST /api/employees - Create employee primary info
- GET /api/employees/{employeeId} - Get employee primary info
- PUT /api/employees/{employeeId} - Update employee primary info
- POST /api/employees/{employeeId}/secondary - Create secondary info
- GET /api/employees/{employeeId}/secondary - Get secondary info
- And similar for education, address, bank, experience, skills, contact
- POST /api/auth/reset-password - Reset password (params: employeeId, oldPassword, newPassword)

Use Postman with Basic Auth (username and password from employee primary info).