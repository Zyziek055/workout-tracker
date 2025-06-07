package com.example.workout_tracker.services;

import com.example.workout_tracker.dtos.WorkoutDto;
import com.example.workout_tracker.mappers.WorkoutMapper;
import com.example.workout_tracker.repositories.WorkoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutMapper workoutMapper;

    public List<WorkoutDto> getUsersWorkouts(Long userId) {
      return workoutRepository.findAllByUser_Id(userId)
              .stream()
              .map(workoutMapper::toDto)
              .toList();
    };
}
