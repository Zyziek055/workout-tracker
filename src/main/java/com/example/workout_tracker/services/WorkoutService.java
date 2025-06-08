package com.example.workout_tracker.services;

import com.example.workout_tracker.dtos.AddWorkoutRequest;
import com.example.workout_tracker.dtos.WorkoutDto;
import com.example.workout_tracker.entities.Workout;
import com.example.workout_tracker.mappers.WorkoutMapper;
import com.example.workout_tracker.repositories.UserRepository;
import com.example.workout_tracker.repositories.WorkoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutMapper workoutMapper;
    private final UserRepository userRepository;

    public List<WorkoutDto> getUsersWorkouts(Long userId) {
      return workoutRepository.findAllByUser_Id(userId)
              .stream()
              .map(workoutMapper::toDto)
              .toList();
    };

    public ResponseEntity<?> addWorkout(Long userId, AddWorkoutRequest workoutRequest, UriComponentsBuilder uriBuilder) {
        var workout = workoutMapper.toEntity(workoutRequest);
        var user = userRepository.findById(userId).orElse(null);
        workout.setUser(user);
        workoutRepository.save(workout);
        return ResponseEntity.created(uriBuilder.path("/workouts/{id}").buildAndExpand(workout.getId()).toUri()).build();
    }
}
