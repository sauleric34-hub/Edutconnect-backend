package com.educonnect.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String city;
    private String neighborhood;

    private String role; // PARENT, TUTOR, ADMIN
    private String status; // ACTIVE, PENDING, SUSPENDED

    private LocalDateTime createdAt = LocalDateTime.now();
}
