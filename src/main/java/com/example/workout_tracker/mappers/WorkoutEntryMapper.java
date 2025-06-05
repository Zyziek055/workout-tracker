package com.example.workout_tracker.mappers;

import com.example.workout_tracker.dtos.WorkoutEntryDto;
import com.example.workout_tracker.entities.WorkoutEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface WorkoutEntryMapper {
    WorkoutEntryDto toDto(WorkoutEntry workoutEntry);
    WorkoutEntry toEntity(WorkoutEntryDto workoutEntryDto);

}
