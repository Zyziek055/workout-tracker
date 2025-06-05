package com.example.workout_tracker.repositories;

import com.example.workout_tracker.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
