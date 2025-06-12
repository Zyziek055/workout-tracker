package com.example.workout_tracker.services;

import com.example.workout_tracker.dtos.AddWorkoutEntryRequest;
import com.example.workout_tracker.dtos.AddWorkoutRequest;
import com.example.workout_tracker.dtos.WorkoutDto;
import com.example.workout_tracker.entities.Workout;
import com.example.workout_tracker.entities.WorkoutEntry;
import com.example.workout_tracker.mappers.WorkoutEntryMapper;
import com.example.workout_tracker.mappers.WorkoutMapper;
import com.example.workout_tracker.repositories.UserRepository;
import com.example.workout_tracker.repositories.WorkoutEntryRepository;
import com.example.workout_tracker.repositories.WorkoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    private final WorkoutEntryMapper workoutEntryMapper;
    private final WorkoutEntryRepository workoutEntryRepository;

    public List<WorkoutDto> getUsersWorkouts(Authentication authentication) {
        var user = userRepository.findByEmail(authentication.getName()).orElse(null);
      return workoutRepository.findAllByUser_Id(user.getId())
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

    public ResponseEntity<?> addWorkoutEntry(Long workoutId, AddWorkoutEntryRequest addWorkoutEntryRequest) {
        var workout = workoutRepository.findById(workoutId).orElse(null);
        if (workout == null) {
            return ResponseEntity.notFound().build();
        }

        var workoutEntry = workoutEntryMapper.toEntity(addWorkoutEntryRequest);
        workoutEntry.setWorkout(workout);

        workoutEntryRepository.save(workoutEntry);

        return ResponseEntity.ok(workoutEntryMapper.toDto(workoutEntry));
    }
}
