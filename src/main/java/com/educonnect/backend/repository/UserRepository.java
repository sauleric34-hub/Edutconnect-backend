package com.educonnect.backend.repository;

import com.educonnect.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByPhone(String phone);
}
