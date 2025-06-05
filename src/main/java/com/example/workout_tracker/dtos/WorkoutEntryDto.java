package com.example.workout_tracker.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WorkoutEntryDto {
    private Long id;
    private String name;
    private String description;
    private int sets;
    private int reps;
    private BigDecimal weight;
}
