<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  
</head>
<body>

<h1>🚗 Dealer & Vehicle Management API + 💳 Payment Gateway Simulation</h1>

<h2>📌 Overview</h2>
<p>
This Spring Boot application provides RESTful APIs for managing dealers, vehicles, and simulating subscription payments.  
It uses <strong>MySQL</strong> as the database, <strong>Spring Data JPA</strong> for persistence, and <strong>Swagger</strong> for API documentation and testing.
</p>

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

<h2>⚙️ Setup Instructions</h2>

<h3>1. Database</h3>
<pre><code>CREATE DATABASE dealerdb;</code></pre>

<h3>2. Application Properties</h3>
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

<h3>3. Build & Run</h3>
<pre><code>
mvn clean install
mvn spring-boot:run
</code></pre>

<h2>🧠 Task 1: Dealer & Vehicle Management</h2>

<h3>Entities</h3>
<ul>
  <li><strong>Dealer</strong>: id, name, email, subscriptionType (BASIC/PREMIUM)</li>
  <li><strong>Vehicle</strong>: id, dealerId (FK), model, price, status (AVAILABLE/SOLD)</li>
</ul>

<h3>APIs</h3>
<ul>
  <li>POST /api/dealers → Create dealer</li>
  <li>GET /api/dealers → List all dealers</li>
  <li>PUT /api/dealers/{id} → Update dealer</li>
  <li>DELETE /api/dealers/{id} → Delete dealer</li>
  <li>POST /api/vehicles → Create vehicle</li>
  <li>GET /api/vehicles → List all vehicles</li>
  <li>PUT /api/vehicles/{id} → Update vehicle</li>
  <li>DELETE /api/vehicles/{id} → Delete vehicle</li>
  <li>GET /api/vehicles/premium → Fetch vehicles belonging to PREMIUM dealers only</li>
</ul>

<h2>💳 Task 2: Payment Gateway Simulation</h2>

<h3>Endpoint</h3>
<p><code>POST /api/payment/initiate</code></p>

<h4>Request Example</h4>
<pre><code>{
  "dealerId": 1,
  "amount": 5000.0,
  "method": "UPI"
}
</code></pre>

<h4>Behavior</h4>
<ul>
  <li>Saves payment with status = "PENDING"</li>
  <li>After 5 seconds, auto-updates status → "SUCCESS" (simulated callback)</li>
</ul>

<h3>Bonus</h3>
<ul>
  <li>Secure APIs using JWT authentication (optional)</li>
</ul>

<h2>🧪 Testing</h2>
<ul>
  <li>Swagger UI: <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a></li>
  <li>Postman collection available for testing endpoints</li>
</ul>

<h2>📜 Deliverables</h2>
<ul>
  <li>Spring Boot project with working APIs</li>
  <li>SQL schema auto-generated via JPA (or manual script if needed)</li>
  <li>Swagger/Postman collection for testing</li>
</ul>

</body>
</html>
