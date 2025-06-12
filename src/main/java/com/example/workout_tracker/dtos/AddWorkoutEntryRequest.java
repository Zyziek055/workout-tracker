package com.example.workout_tracker.dtos;

import com.example.workout_tracker.entities.Workout;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddWorkoutEntryRequest {
    @NotBlank
    @Size(max=255, message = "Name must be less than 255 characters")
    private String name;

    private String description;

    @NotBlank
    private int sets;

    @NotBlank
    private int reps;
    @NotBlank
    private BigDecimal weight;
}
