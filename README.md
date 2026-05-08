# User Manager – GraphQL CRUD Application

A full-stack CRUD application built using **React, GraphQL, and Apollo** on the frontend, and **Java Spring Boot 3** on the backend with **PostgreSQL** persistence, **JWT-based authentication**, and **Docker** containerization.

The application allows users to create, read, update, and delete users with basic details like name, age, and marital status — with role-based access control (ADMIN/USER).

---

## 🚀 Features

- ➕ Create a new user
- 📋 View all users
- 🔍 Search users by name
- 🆔 Fetch a user by ID
- ✏️ Update user marital status
- ❌ Delete users
- 🔐 JWT-based authentication (ADMIN / USER roles)
- 📄 Limit/offset pagination with advanced filtering
- 🎨 Clean card-based UI

---

## 🛠 Tech Stack

### Frontend
- React
- Apollo Client
- JavaScript
- CSS

### Backend
- Java 21
- Spring Boot 3
- Spring for GraphQL
- Spring Security + JWT
- Spring Data JPA + Hibernate
- PostgreSQL

### DevOps
- Docker
- Docker Compose

---

## 📂 Project Structure

```
project-root
│
├── client/                        # React frontend
│   ├── src/
│   │   ├── App.jsx
│   │   ├── App.css
│   │   └── main.jsx
│   └── package.json
│
├── server-java/                   # Spring Boot backend
│   ├── src/main/java/com/example/usermanager/
│   │   ├── controller/
│   │   │   └── UserController.java
│   │   ├── model/
│   │   │   ├── User.java
│   │   │   └── Role.java
│   │   ├── repository/
│   │   │   └── UserRepository.java
│   │   ├── security/
│   │   │   ├── JwtUtil.java
│   │   │   ├── JwtFilter.java
│   │   │   └── SecurityConfig.java
│   │   ├── service/
│   │   │   └── UserService.java
│   │   └── UsermanagerApplication.java
│   ├── src/main/resources/
│   │   ├── graphql/
│   │   │   └── schema.graphqls
│   │   └── application.properties
│   └── Dockerfile
│
├── docker-compose.yml
└── README.md
```

---

## ⚙️ Installation & Setup

### Prerequisites
- Docker Desktop
- Node.js (for frontend)

---

### 1️⃣ Clone the repository

```bash
git clone <your-repo-link>
cd user_manager
```

---

### 2️⃣ Start Backend (Spring Boot + PostgreSQL via Docker)

```bash
docker-compose up --build
```

This will:
- Start PostgreSQL on port `5432`
- Build and start the Spring Boot app on port `8080`

Backend runs at:
```
http://localhost:8080
```

GraphiQL Playground:
```
http://localhost:8080/graphiql
```

---

### 3️⃣ Start React Frontend

```bash
cd client
npm install
npm run dev
```

Frontend runs at:
```
http://localhost:5173
```

---

## 🔗 GraphQL Operations

### Queries

```graphql
getUsers(limit: Int, offset: Int, name: String): [User]
getUserById(id: ID!): User
```

### Mutations

```graphql
createUser(name: String!, age: Int!, isMarried: Boolean!, password: String!): User
updateUser(id: ID!, isMarried: Boolean!): User
deleteUser(id: ID!): Boolean
login(name: String!, password: String!): String
```

---

## 🔐 Authentication

Login mutation returns a **JWT token**:

```graphql
mutation {
  login(name: "Sneha", password: "sneha123")
}
```

Use the token in request headers:
```
Authorization: Bearer <token>
```

Roles: `ADMIN` and `USER`

---

## 🧠 How It Works

1. React frontend sends GraphQL queries and mutations using Apollo Client.
2. Spring for GraphQL processes the request via `@QueryMapping` and `@MutationMapping`.
3. Spring Security validates the JWT token on each request.
4. Service layer interacts with PostgreSQL via Spring Data JPA.
5. Updated data is returned and displayed instantly in the UI.

---

## 📌 Example User Object

```json
{
  "id": "uuid-string",
  "name": "Sneha Singh",
  "age": 21,
  "isMarried": false,
  "role": "USER"
}
```

---

## 🎯 Learning Objectives

This project demonstrates:

- GraphQL schema and resolvers with Spring for GraphQL
- Apollo Client integration with React
- Full-stack React + GraphQL + Java workflow
- CRUD operations using GraphQL
- JWT-based authentication and role-based authorization
- PostgreSQL persistence with Spring Data JPA
- Docker containerization with Docker Compose
- Limit/offset pagination and filtering

---

## ✅ Improvements Made (Migration from Node.js)

| Feature | Before | After |
|---|---|---|
| Backend | Node.js + Apollo Server | Java Spring Boot 3 |
| Database | In-memory (data lost on restart) | PostgreSQL (persistent) |
| Auth | None | JWT (ADMIN/USER roles) |
| Containerization | None | Docker + Docker Compose |
| Setup time | ~45 min | ~2 min (`docker-compose up`) |
| Pagination | None | Limit/Offset supported |
| Filtering | None | Filter by name supported |
<img width="825" height="870" alt="{A0D3ECD2-8E65-4B27-A9D4-91A1BE3DC13A}" src="https://github.com/user-attachments/assets/350d796d-bdb1-4826-8a55-b18a424cf751" />


B.Tech IT Student
React Developer | Open Source Enthusiast
