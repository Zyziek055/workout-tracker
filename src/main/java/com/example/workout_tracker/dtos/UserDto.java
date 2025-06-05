package com.example.workout_tracker.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    @JsonProperty("user-id")
    private Long id;
    private String name;
    private String email;
}
