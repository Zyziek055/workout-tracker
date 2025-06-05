package com.example.workout_tracker.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class WorkoutDto {
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private Long userId;
    private List<WorkoutEntryDto> entries = new ArrayList<>();


}
