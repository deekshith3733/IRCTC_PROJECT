package com.example.IRTC.booking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.IRTC.booking.DTO.LoginRequest;
import com.example.IRTC.booking.DTO.SignupRequest;
import com.example.IRTC.booking.Repositories.UserRepository;
import com.example.IRTC.booking.Service.JwtUtil;
import com.example.IRTC.booking.model.User;


@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody SignupRequest request) {
        // Validate input
        if (request.getName() == null || request.getEmail() == null || request.getPassword() == null) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "Name, email, and password must not be null"));
        }

        // Check if email already exists
        if (userRepo.findByEmail(request.getEmail()) != null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Email is already registered"));
        }

        // Create user
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));

        // Save user
        User savedUser = userRepo.save(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "message", "User registered successfully",
                        "email", savedUser.getEmail(),
                        "name", savedUser.getName()
                ));
    }



    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        if (request.getEmail() == null || request.getPassword() == null) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "Email and password must not be null"));
        }

        User user = userRepo.findByEmail(request.getEmail());

        if (user == null || !encoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid credentials"));
        }

       // String token = jwtUtil.generateToken(user.getEmail());

        return ResponseEntity.ok(
                Map.of(
                        "email", user.getEmail(),
                        "name", user.getName()
                )
        );
    }

}


