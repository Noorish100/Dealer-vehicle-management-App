<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Dealer & Vehicle Management API</title>
</head>
<body>

<h1>🚗 Dealer & Vehicle Management API + 💳 Payment Gateway Simulation</h1>

<h2>📌 Overview</h2>
<p>This Spring Boot application provides RESTful APIs for managing dealers, vehicles, and simulating subscription payments. It uses <strong>MySQL</strong> as the database and supports Swagger for API testing.</p>

<h2>🧩 Technologies Used</h2>
<ul>
  <li>Java 17</li>
  <li>Spring Boot 3.2.5</li>
  <li>Spring Data JPA</li>
  <li>MySQL</li>
  <li>Swagger (SpringDoc)</li>
  <li>Lombok</li>
  <li>Maven</li>
</ul>

<h2>📁 Project Structure</h2>
<pre>
src/
├── main/
│   ├── java/com/app/
│   │   ├── controller/
│   │   ├── entity/
│   │   ├── repository/
│   │   ├── service/
│   │   └── VehicleManagementApplication.java
│   └── resources/
│       ├── application.properties
│       └── schema.sql (optional)
</pre>

<h2>🧪 Setup Instructions</h2>

<h3>✅ 1. Configure MySQL</h3>
<pre><code>CREATE DATABASE dealerdb;</code></pre>

<h3>✅ 2. Update <code>application.properties</code></h3>
<pre><code>
spring.datasource.url=jdbc:mysql://localhost:3306/dealerdb
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
</code></pre>

<h2>🧠 Task 1: Dealer & Vehicle Management</h2>

<h3>🏗️ Entities</h3>
<ul>
  <li><strong>Dealer</strong>: id, name, email, subscriptionType (BASIC, PREMIUM)</li>
  <li><strong>Vehicle</strong>: id, dealerId (FK), model, price, status (AVAILABLE, SOLD)</li>
</ul>

<h3>🔧 APIs</h3>
<ul>
  <li>POST /api/dealers</li>
  <li>GET /api/dealers</li>
  <li>PUT /api/dealers/{id}</li>
  <li>DELETE /api/dealers/{id}</li>
  <li>POST /api/vehicles</li>
  <li>GET /api/vehicles</li>
  <li>PUT /api/vehicles/{id}</li>
  <li>DELETE /api/vehicles/{id}</li>
  <li>GET /api/vehicles/premium</li>
</ul>

<h2>💳 Task 2: Payment Gateway Simulation</h2>

<h3>🔧 Endpoint</h3>
<p><code>POST /api/payment/initiate</code></p>

<h4>Request Body</h4>
<pre><code>{
  "dealerId": 1,
  "amount": 5000.0,
  "method": "UPI"
}
</code></pre>

<h4>Behavior</h4>
<ul>
  <li>Saves payment with status <code>PENDING</code></li>
  <li>After 5 seconds, auto-updates status to <code>SUCCESS</code> (simulated callback)</li>
</ul>

<h3>🛡️ Bonus: JWT Authentication (Optional)</h3>
<ul>
  <li>Secure endpoints using JWT</li>
  <li>Add login and token generation logic</li>
  <li>Protect <code>/api/payment/initiate</code> with token validation</li>
</ul>

<h2>🧪 Testing</h2>

<h3>🔍 Swagger UI</h3>
<p>Access Swagger at: <code>http://localhost:8080/swagger-ui.html</code></p>

<h3>📦 Postman Collection</h3>
<p>Import the provided Postman collection to test all endpoints.</p>

<h2>📜 SQL Schema (Optional)</h2>
<p>If not using JPA auto-generation, include a <code>schema.sql</code> with:</p>
<pre><code>
CREATE TABLE dealer (...);
CREATE TABLE vehicle (...);
CREATE TABLE payment (...);
</code></pre>

</body>
</html>
