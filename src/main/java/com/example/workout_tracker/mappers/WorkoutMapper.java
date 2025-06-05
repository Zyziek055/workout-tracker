package com.example.workout_tracker.mappers;

import com.example.workout_tracker.dtos.WorkoutDto;
import com.example.workout_tracker.entities.Workout;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface WorkoutMapper {
    WorkoutDto toDto(Workout workout);
    Workout toEntity(WorkoutDto workoutDto);
}
