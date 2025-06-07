package com.example.workout_tracker.controllers;

import com.example.workout_tracker.dtos.WorkoutDto;
import com.example.workout_tracker.services.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/{userId}/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    @GetMapping
    public List<WorkoutDto> getUsersWorkouts(@PathVariable Long userId) {
        return workoutService.getUsersWorkouts(userId);
    }

}
