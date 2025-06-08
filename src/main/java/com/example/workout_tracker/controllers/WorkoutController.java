package com.example.workout_tracker.controllers;

import com.example.workout_tracker.dtos.AddWorkoutRequest;
import com.example.workout_tracker.dtos.WorkoutDto;
import com.example.workout_tracker.services.WorkoutService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/{userId}/workouts") //This is wrong, but I'll make it /workouts after I figure
//out how to do proper authetication with JWT tokens
public class WorkoutController {
    private final WorkoutService workoutService;

    @GetMapping
    public List<WorkoutDto> getUsersWorkouts(@PathVariable Long userId) {
        return workoutService.getUsersWorkouts(userId);
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
