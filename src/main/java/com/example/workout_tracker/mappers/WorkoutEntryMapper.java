package com.example.workout_tracker.mappers;

import com.example.workout_tracker.dtos.WorkoutEntryDto;
import com.example.workout_tracker.entities.WorkoutEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkoutEntryMapper {
    WorkoutEntryDto toDto(WorkoutEntry workoutEntry);
    WorkoutEntry toEntity(WorkoutEntryDto workoutEntryDto);
    @Mapping(target = "id", ignore=true)
    void update(WorkoutEntryDto workoutEntryDto, WorkoutEntry workoutEntry);

}
