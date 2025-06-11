package com.example.workout_tracker.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    public String generateToken(String email) {
        final long tokenbExpiration = 86400;

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis() + 100*tokenbExpiration)
                )
                .signWith(Keys.hmacShaKeyFor("secretsecretsecretsecretsecretsecret".getBytes()))
                .compact();
    }
}
