package com.educonnect.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
public class DemoDataController {

    @GetMapping("/overview")
    public OverviewResponse overview() {
        return new OverviewResponse(
            List.of(
                new Metric("Eleves suivis", "2", "+1 ce mois", "student"),
                new Metric("Seances confirmees", "8", "3 cette semaine", "session"),
                new Metric("Budget mensuel", "42 000 FCFA", "MoMo securise", "wallet"),
                new Metric("Progression moyenne", "78%", "+12% en maths", "progress")
            ),
            List.of(
                new Student("EDU-CM-482915", "Marie Fotso", "3eme", "Lycee Joss", "Mathematiques", 82, "Jean T.", "Demain 16h00"),
                new Student("EDU-CM-928441", "Paul Fotso", "1ere D", "College Libermann", "Physique", 71, "Alice M.", "Vendredi 18h00")
            ),
            List.of(
                new Session("Mathematiques", "Marie Fotso", "Jean T.", "Demain", "16h00 - 18h00", "Domicile", "CONFIRMEE", 7000),
                new Session("Physique", "Paul Fotso", "Alice M.", "Vendredi", "18h00 - 20h00", "En ligne", "PLANIFIEE", 8000),
                new Session("Anglais", "Marie Fotso", "Sophie N.", "Samedi", "10h00 - 11h30", "Lieu neutre", "EN_ATTENTE", 6000)
            )
        );
    }

    @GetMapping("/tutors")
    public List<TutorResponse> tutors() {
        return List.of(
            new TutorResponse("JT", "Jean T.", "Universite de Douala", "Master Informatique", "Akwa", "Douala", List.of("Mathematiques", "Physique"), 3500, 4.8, 24, 96, true, "Disponible demain"),
            new TutorResponse("AM", "Alice M.", "Ecole Normale Superieure", "Master Physique", "Bonamoussadi", "Douala", List.of("Physique", "Chimie"), 4000, 4.7, 18, 91, true, "Disponible ce soir"),
            new TutorResponse("SN", "Sophie N.", "Universite de Yaounde I", "Licence Anglais", "Melen", "Yaounde", List.of("Anglais", "Francais"), 3000, 4.6, 12, 88, true, "Week-end"),
            new TutorResponse("BN", "Bryan N.", "Keyce Informatique", "L2 Genie logiciel", "Makepe", "Douala", List.of("Informatique", "Mathematiques"), 4500, 4.9, 31, 98, true, "Top tuteur")
        );
    }

    @GetMapping("/admin")
    public AdminResponse admin() {
        return new AdminResponse(
            List.of(
                new Metric("Nouveaux inscrits", "+24", "Aujourd'hui", "users"),
                new Metric("Tuteurs en attente", "12", "Validation requise", "shield"),
                new Metric("Litiges ouverts", "2", "A traiter", "alert"),
                new Metric("Seances actives", "48", "Temps reel", "activity")
            ),
            List.of(
                new PendingTutor("Sophie N.", "Universite de Yaounde I", "Anglais", "Il y a 2h", 86),
                new PendingTutor("Bryan N.", "Keyce Informatique", "Informatique", "Il y a 4h", 92),
                new PendingTutor("Armel K.", "Universite de Douala", "Mathematiques", "Hier", 78)
            )
        );
    }

    @PostMapping("/booking")
    public ActionResponse booking(@RequestBody Map<String, String> payload) {
        String tutor = payload.getOrDefault("tutor", "le tuteur selectionne");
        return new ActionResponse("Demande envoyee", "La reservation avec " + tutor + " est en attente de confirmation.");
    }

    @PostMapping("/auth/demo")
    public ActionResponse auth(@RequestBody Map<String, String> payload) {
        String role = payload.getOrDefault("role", "parent");
        return new ActionResponse("Connexion demo", "Session " + role + " initialisee avec succes.");
    }

    public record OverviewResponse(List<Metric> metrics, List<Student> students, List<Session> sessions) {}
    public record AdminResponse(List<Metric> metrics, List<PendingTutor> pendingTutors) {}
    public record Metric(String label, String value, String hint, String type) {}
    public record Student(String id, String name, String level, String school, String weakSubject, int progress, String activeTutor, String nextSession) {}
    public record Session(String subject, String student, String tutor, String day, String time, String place, String status, int amount) {}
    public record TutorResponse(String initials, String name, String university, String level, String neighborhood, String city, List<String> subjects, int hourlyRate, double rating, int reviewCount, int reliabilityScore, boolean verified, String availability) {}
    public record PendingTutor(String name, String university, String subject, String submittedAt, int profileScore) {}
    public record ActionResponse(String title, String message) {}
}
