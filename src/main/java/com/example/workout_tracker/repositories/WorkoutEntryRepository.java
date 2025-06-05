package com.example.workout_tracker.repositories;

import com.example.workout_tracker.entities.WorkoutEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutEntryRepository extends JpaRepository<WorkoutEntry, Long> {
}
