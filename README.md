# Spring Boot 4 Microservices Project

A full **Microservices architecture** project built with **Spring Boot 4**

This repository contains all services and related configurations to demonstrate a microservices-oriented application with scalable and independent components.

---

## 📌 Project Overview

This project implements an architecture composed of multiple services which communicate using REST / Spring Cloud stack. Each service runs independently and can be deployed, scaled, and tested in isolation.

✔️ Built using Spring Boot 4  
✔️ Distributed system architecture  
✔️ API Gateway  
✔️ Multiple backend services  
✔️ Docker support  

## 🚀 Services Included

List the services you have in your project (example):

| Service | Description |
|---------|-------------|
| **api-gateway** | Single entry point for all clients |
| **product-service** | Handles product management |
| **order-service** | Processes orders |
| **inventory-service** | Manages inventory |
| **notification-service** | Sends notifications to users |

---

## 🛠 Tech Stack

| Category | Technologies |
|----------|--------------|
| Backend | Spring Boot 4 |
| API Routing | Spring Cloud Gateway |
| Database | MySQL / MongoDB *(optional per service)* |
| Messaging | Kafka *(if used)* |
| Containers | Docker |

---

## 🧩 Prerequisites

Make sure you have the following installed:

✔️ Java 21+  
✔ Maven  
✔ Docker & Docker-Compose