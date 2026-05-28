# EduConnect Cameroun - Backend API

Bienvenue sur le dépôt Backend du projet **EduConnect Cameroun**. 
L'API robuste qui propulse "Le bon répétiteur, vérifié, proche et suivi."

## 🚀 Présentation
Ce dépôt contient le code source de l'API RESTful développée en **Java Spring Boot**, chargée de gérer la logique métier d'EduConnect : l'authentification, la recherche et le matching des tuteurs, la réservation des séances, et les simulations de paiements Mobile Money.

## 🛠 Technologies
- **Java 17**
- **Spring Boot 3.2.x**
  - Spring Web (API REST)
  - Spring Data JPA (Hibernate)
  - Spring Security
- **MySQL** (Base de données relationnelle)
- **Lombok** (Réduction du code boilerplate)
- **Maven** (Gestionnaire de dépendances)

## 📂 Architecture
L'architecture suit le modèle MVC classique pour les API REST :
```
src/main/java/com/educonnect/backend/
├── config/        # Configurations globales (Sécurité, CORS...)
├── controller/    # Endpoints de l'API REST (/api/...)
├── model/         # Entités JPA (User, Parent, Tutor, Student, TutoringSession)
├── repository/    # Interfaces d'accès aux données (Data JPA)
└── service/       # Logique métier et algorithmes
```

## ⚙️ Prérequis et Configuration

1. **Base de données MySQL** :
   Assurez-vous d'avoir une instance MySQL locale tournant sur le port `3306`.
   Créez une base de données vide nommée `educonnect` :
   ```sql
   CREATE DATABASE educonnect;
   ```

2. **Configuration `application.properties`** :
   Les paramètres par défaut dans `src/main/resources/application.properties` sont configurés pour l'utilisateur `root` sans mot de passe.
   *Modifiez ce fichier si vos identifiants MySQL locaux sont différents.*

## 🚀 Lancement

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/sauleric34-hub/Edutconnect-backend.git
   ```
2. Lancer l'application via Maven :
   ```bash
   cd Edutconnect-backend
   ./mvnw spring-boot:run
   ```
3. L'API démarrera sur le port `8080`.
   - Test de santé : `GET http://localhost:8080/api/ping`

## 🔒 Sécurité
Pour faciliter le développement du MVP en local, Spring Security est actuellement configuré pour autoriser toutes les requêtes entrantes (`permitAll()`) sur les routes `/api/**`. Cette configuration devra être durcie avec JWT pour la mise en production.

---
*Projet réalisé pour EduConnect Cameroun (2026).*