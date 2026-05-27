package com.educonnect.backend.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Tutor extends User {
    private String university;
    private String major;
    private String studyLevel;
    private Double hourlyRate;
    private Integer reliabilityScore;
    private String mobileMoneyAccount;
    private String subscription; // FREE, PREMIUM
}
