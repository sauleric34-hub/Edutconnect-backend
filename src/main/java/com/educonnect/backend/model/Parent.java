package com.educonnect.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Parent extends User {
    private String subscription; // FREE, STANDARD, PREMIUM
    private Double walletBalance;

    @OneToMany(mappedBy = "parent")
    private List<Student> students;
}
