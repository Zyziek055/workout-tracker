package com.example.workout_tracker.repositories;

import com.example.workout_tracker.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
