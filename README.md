# E-Learning Android App

**Code Elevate** is a mobile e-learning application designed to help users learn popular programming languages like **Java** and **C++** interactively.  
The app includes structured lessons, quizzes, progress tracking, and leaderboards to enhance the learning experience.  

---

## 🧭 Table of Contents

1. [Introduction](#introduction)  
2. [Features](#features)  
3. [Project Structure](#project-structure)  
4. [Installation](#installation)  
5. [Usage](#usage)  
6. [Dependencies](#dependencies)  
7. [Configuration](#configuration)  
8. [Screens and Activities](#screens-and-activities)  
9. [Troubleshooting](#troubleshooting)  
10. [Contributors](#contributors)  
11. [License](#license)

---

## 🧩 Introduction

**Code Elevate** is an Android-based e-learning platform that provides interactive coding lessons, quizzes, and leaderboards to help learners build programming skills in a fun and competitive environment.  
It supports multiple languages and includes both **student** and **admin** functionalities.

---

## 🚀 Features

- 👨‍💻 **User Authentication** – Login and sign-up functionality for learners.  
- 📖 **Interactive Lessons** – Learn Java and C++ through structured lessons.  
- 🧠 **Quizzes & Practice** – Test your knowledge with quizzes after each lesson.  
- 🏆 **Leaderboard System** – Compete with others and track your learning progress.  
- 🧑‍🏫 **Admin Dashboard** – Manage users, lessons, and content.  
- 📱 **Modern UI** – Simple and user-friendly Android interface.  
- ☁️ **Firebase Integration** – For authentication and data management.

---

## 🗂️ Project Structure

```
Code-Elevate/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/codeelevate/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── LoginActivity.java
│   │   │   │   ├── LanguageSelection.java
│   │   │   │   ├── LeaderBoard.java
│   │   │   │   ├── Admin.java
│   │   │   │   ├── C_Plus_Plus.java
│   │   │   │   ├── Java.java
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       ├── values/
│   │   │       └── drawable/
│   ├── build.gradle
│   ├── google-services.json
│   └── proguard-rules.pro
│
├── build.gradle
├── gradle.properties
├── settings.gradle
└── README.md
```

---

## ⚙️ Installation

### Prerequisites
- Android Studio (latest version recommended)
- JDK 8 or higher
- Gradle (comes bundled with Android Studio)
- Firebase project setup

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/E-Learning-App.git
   cd E-Learning-App
   ```

2. **Open the project in Android Studio**

3. **Sync Gradle**  
   Go to `File > Sync Project with Gradle Files`

4. **Add Firebase Configuration**  
   - Place your `google-services.json` file inside the `app/` directory.

5. **Run the app**  
   Click ▶️ **Run** or use:
   ```bash
   ./gradlew assembleDebug
   ```

---

## 🧭 Usage

1. Launch the app on your device or emulator.  
2. Create a new account or log in with existing credentials.  
3. Select a programming language (e.g., Java or C++).  
4. Browse lessons, take quizzes, and track your progress.  
5. View rankings in the leaderboard.  
6. (Admins only) Manage lessons and view analytics.

---

## 🧩 Dependencies

- **AndroidX Libraries**
- **Firebase Authentication**
- **Firebase Realtime Database / Firestore**
- **Material Components for Android**
- **Gradle Build Tools**

These dependencies are defined in `app/build.gradle`.

---

## 🔧 Configuration

To connect with Firebase:
1. Create a Firebase project at [Firebase Console](https://console.firebase.google.com/).  
2. Add an Android app and download the `google-services.json` file.  
3. Place it in `app/`.  
4. Enable **Authentication** and **Realtime Database** in Firebase.

---

## 🖥️ Screens and Activities

| Activity | Description |
|-----------|--------------|
| `MainActivity` | App entry point; redirects to login or dashboard. |
| `LoginActivity` | Handles user authentication. |
| `LanguageSelection` | Allows users to select programming language. |
| `Java.java`, `C_Plus_Plus.java` | Contain lesson content. |
| `LeaderBoard.java` | Displays user rankings. |
| `Admin.java`, `Admin_Main_Page.java` | Admin management screens. |

---

## 🩹 Troubleshooting

| Issue | Solution |
|--------|-----------|
| Firebase connection failed | Check your `google-services.json` and Firebase configuration. |
| App won’t build | Try `File > Invalidate Caches / Restart` in Android Studio. |
| Login issues | Ensure Firebase Authentication is enabled and credentials are correct. |

---

## 👨‍💻 Contributors

- **Author:** You (Project Owner)  

Contributions are welcome! Feel free to fork this project and submit pull requests to improve Code Elevate.

---

## ⚖️ License

This project currently has **no license**.  
All rights reserved by the author.

---

### 🌟 Acknowledgements

- Android Studio Team  
- Firebase by Google  
- Open-source Android community  

---

> *Code Elevate — Empowering learners to code smarter.*
