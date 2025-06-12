package com.example.workout_tracker.controllers;

import com.example.workout_tracker.dtos.AddWorkoutRequest;
import com.example.workout_tracker.dtos.WorkoutDto;
import com.example.workout_tracker.services.WorkoutService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    @GetMapping
    public List<WorkoutDto> getUsersWorkouts(Authentication Authentication) {
        return workoutService.getUsersWorkouts(Authentication);
    }

    @PostMapping
    public ResponseEntity<?> addWorkout(
            @PathVariable Long userId,
                           @RequestBody AddWorkoutRequest addWorkoutRequest,
                           UriComponentsBuilder uriBuilder
    ) {
        return workoutService.addWorkout(userId, addWorkoutRequest, uriBuilder);
    }

}
