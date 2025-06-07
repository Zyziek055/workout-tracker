package com.example.workout_tracker.repositories;

import com.example.workout_tracker.entities.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(@NotBlank String email);
}
