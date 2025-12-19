# Market Core System

> **Academic Capstone Project** | Programming 2 (Programación 2)  
> **Universidad ORT Uruguay** | Semester: March 2023

## Project Overview
This application is a full-scale commercial management platform built with **Java** and **Swing**. It was designed to manage the complex ecosystem of a wholesale market, including the registration of stalls, owners, wholesalers, and products, as well as the processing of daily transactions.

## Features
* **Commercial Entity Management:** Complete CRUD for Stalls (Puestos), Owners, and Wholesalers.
* **Transaction System:** Logic for recording and validating purchases and sales between entities.
* **Data Persistence:** Implementation of **Serialization** to save and load the system state (`salida.ser`).
* **Custom Reporting:** Search and filtering tools to analyze sales performance and stock.
* **Advanced GUI:** Built using Java Swing with image support for product visualization.
* **Business Logic:** Robust object-oriented design (OO) with custom sorting criteria and input validation.

## Technical Stack
* **Language:** Java 11+
* **GUI Framework:** Java Swing (NetBeans Form Editor)
* **Persistence:** Java Serialization (Object Streams)
* **Architecture:** Domain-Driven Design (DDD) approach

## 📂 Project Structure
* `src/dominio`: Business logic and core entities.
* `src/interfaz`: UI components and event handling.
* `src/main`: Application entry point.
