package com.example.workout_tracker.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddWorkoutRequest {
    @NotBlank
    @Size(max=255, message = "Name must be less than 255 characters")
    private String name;

    private String description;

    private LocalDate date;

    private LocalTime time;
}
