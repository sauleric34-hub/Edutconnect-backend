package com.educonnect.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "sessions")
public class TutoringSession {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    private String subject;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer durationMinutes;
    private String location;
    
    private String status; // PLANNED, CONFIRMED, IN_PROGRESS, COMPLETED, CANCELLED, DISPUTE
    
    private Double totalAmount;
    private Double platformCommission;
    private Double tutorNetAmount;
    
    @Column(length = 1000)
    private String tutorNotes;
    
    private Integer rating;
}
