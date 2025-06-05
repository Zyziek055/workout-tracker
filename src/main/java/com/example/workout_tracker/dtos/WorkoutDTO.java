package com.example.workout_tracker.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WorkoutDTO {
    private Long id;
    private List<WorkoutEntryDto> entries = new ArrayList<>();

}
