package com.example.workout_tracker.mappers;

import com.example.workout_tracker.dtos.RegisterUserRequest;
import com.example.workout_tracker.dtos.UpdateUserRequest;
import com.example.workout_tracker.dtos.UserDto;
import com.example.workout_tracker.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
