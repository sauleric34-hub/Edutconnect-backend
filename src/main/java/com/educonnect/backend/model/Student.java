package com.educonnect.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;
    private String studentClass;
    private String school;
    
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
