# 🎓 Student Management System (Java Swing)

A desktop-based **Student Management System** developed using **Java Swing** that enables users to efficiently manage student records through a simple and interactive graphical user interface.

---

## 🚀 Features

- ➕ Add student records (Roll Number, Name, Marks)  
- 📋 View all stored students  
- 🔍 Search student by Roll Number  
- ❌ Delete student records  
- 💾 Automatic data saving using serialization (`data.dat`)  
- 🔄 Data persists after restarting the application  

---

## 🛠️ Technologies Used

- Java (Core Java)  
- Java Swing (GUI Development)  
- Object-Oriented Programming (OOP)  
- File Handling (Serialization & Deserialization)  
- ArrayList  

---

## ⚙️ How It Works

- Data is stored in an `ArrayList<StudentData>`  
- Each student is an object  
- Data is saved using serialization into `data.dat`  
- On startup, data is loaded automatically  
- Buttons perform Add, Show, Search, Delete operations  

---

## 🖥️ User Interface

- Input fields for Roll Number, Name, Marks  
- Buttons for operations  
- Display area for output  

---

## 📂 Project Structure

```
Student-Management-System/
│
├── StudentGUI.java
├── data.dat
└── README.md
```

---

## ▶️ How to Run

```bash
git clone https://github.com/dishaangalwar84/java_mini_project.git
cd java_mini_project
javac StudentGUI.java
java StudentGUI
```

---

## 💡 Future Enhancements

- Update/Edit student details  
- Sorting (by marks or name)  
- Improved UI  
- Database integration (MySQL)  
- Authentication system  

---

## 🎯 Learning Outcomes

- Java Swing GUI development  
- File handling & serialization  
- OOP concepts  
- Dynamic data handling using ArrayList  

---

