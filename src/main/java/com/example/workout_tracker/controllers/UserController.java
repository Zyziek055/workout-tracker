package com.example.workout_tracker.controllers;

import com.example.workout_tracker.dtos.RegisterUserRequest;
import com.example.workout_tracker.dtos.UserDto;
import com.example.workout_tracker.mappers.UserMapper;
import com.example.workout_tracker.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public Iterable<UserDto> getAllUsers (
            @RequestParam(required = false, defaultValue = "", name = "sort") String sort
    ) {
        if (!Set.of("name", "email").contains(sort)) {
            sort = "name";
        }

        return userRepository.findAll(Sort.by(sort))
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @PostMapping
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder //this builds response url
    ) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(
                    Map.of("email", "Email is already taken")
            );
        };
        var user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        var userDto = userMapper.toDto(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }
}

