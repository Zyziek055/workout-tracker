package com.example.workout_tracker.repositories;

import com.example.workout_tracker.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findAllByUser_Id(Long userId);
}
