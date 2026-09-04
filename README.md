# 🚀 Login & Registration System (Spring Boot + React)

This is a full-stack authentication project with:

* 🔙 Backend: Spring Boot (Java)
* 🎨 Frontend: React (Vite)

---

## 📁 Project Structure

```
projects/
 ├── back-end/     # Spring Boot API
 └── front-end/    # React App (Vite)
```

---

## ⚙️ Prerequisites

Make sure you have installed:

* Java 17+
* Maven
* Node.js (v18+ recommended)
* npm or yarn

---

## 🔽 Clone the Repository

```bash
git clone https://github.com/<your-username>/<your-repo>.git
cd <your-repo>
```

---

# 🔙 Backend Setup (Spring Boot)

### 📍 Navigate to backend

```bash
cd back-end
```

### ▶️ Run the backend

#### Option 1: Using Maven Wrapper

```bash
./mvnw spring-boot:run
```

#### Option 2: Using Maven

```bash
mvn spring-boot:run
```

---

### 🌐 Backend runs on:

```
http://localhost:8080
```

---

## 🔐 Environment Variables (Backend)

configure inside `application.properties`:

Example:

```
DB_URL=your_database_url
DB_USERNAME=your_username
DB_PASSWORD=your_password
JWT_SECRET=your_secret
```

---

# 🎨 Frontend Setup (React + Vite)

### 📍 Navigate to frontend

```bash
cd front-end
```

### 📦 Install dependencies

```bash
npm install
```

### ▶️ Run the frontend

```bash
npm run dev
```

---

### 🌐 Frontend runs on:

```
http://localhost:5173
```

---

## 🔗 API Connection

Make sure your frontend API base URL points to:

```
http://localhost:8080
```

---

## 🧪 Features

* User Registration
* User Login
* Protected Routes
* JWT Authentication

---

## 👨‍💻 Author

* Madan

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
