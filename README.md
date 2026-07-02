# 🐾 PawSafe — Flood Disaster Animal Rescue System

PawSafe is a Java Desktop (Swing/JFrame) application designed to facilitate the coordination and evacuation of stranded pets during flood disasters. This project is developed as the Final Project (UAS) for the Object-Oriented Programming (OOP) Practical Course.

## 🚀 Key Features
1. **Stray & Stranded Animal Reporting:** Allows users to submit reports on trapped animals, complete with locations and health status.
2. **Animal-Friendly Shelter Management:** Tracks available shelters, emergency posts, and their current capacity.
3. **Volunteer Coordination Hub:** Manages active rescue volunteers and dispatches them based on report urgency.
4. **AI-Powered Evacuation Consultant:** Integrates Large Language Models (LLM) API to provide real-time first aid advice and evacuation guidelines for rescued animals.

## 🛠️ OOP Concepts Applied (90% Assessment)
- **Encapsulation:** All model attributes are securely hidden (`private`) and accessed strictly through controlled getters and setters.
- **Inheritance:** Implemented across core actors (`Pengguna` → `Relawan`, `Admin`) and entities (`Hewan` → `Anjing`, `Kucing`).
- **Polymorphism:** Method overriding used in dynamic descriptions (`getDeskripsi()`) and user info displays (`tampilkanInfo()`).
- **Interfaces:** Standardized action contracts using the `DapatDievakuasi` interface to calculate rescue priorities.
- **Generic Programming:** A universal `DataManager<T>` class to handle CRUD operations dynamically across different data models.
- **File I/O & Exception Handling:** Structured data persistence using `.csv` storage combined with strict robust robust `try-catch` validation (Upcoming).

## 🧠 AI Integration (10% Assessment)
- Connected to an AI/LLM API to dynamically analyze animal conditions and give tailored safety advice to rescuers on the field.

## 👥 Team Members (Group 5)
- **Valencia Angela Permatasari** (A11.2024.15537)
- **Sabrina Angel Lilga Putri.M.** (A11.2024.15596)
- **Bungalunna Nashuha Camelia** (A11.2024.15611)

---
*Developed for Universitas Dian Nuswantoro (UDINO) Semarang - 2026.*
