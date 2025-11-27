package com.example.IRTC.booking.controller;

import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.IRTC.booking.Repositories.UserLoginDetailsRepository;
import com.example.IRTC.booking.Service.SecurityConfig;
import com.example.IRTC.booking.model.UserLoginDetails;
@RestController
@RequestMapping("/user-login-details")
public class UserLoginDetailController {

    @Autowired
    private UserLoginDetailsRepository userLoginDetailsRepo;

   
    // Get user login details by mobile number
    @GetMapping("/")
    public ResponseEntity<Object> getUserLoginDetails(@RequestParam String mobileNumber) {
        UserLoginDetails user = userLoginDetailsRepo.findByMobileNumber(mobileNumber);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "User not found"));
        }
        return ResponseEntity.ok(user);
    }

    // Validate user login
    @GetMapping("/validate")
    public ResponseEntity<Object> validateUserLogin(@RequestParam String mobileNumber, @RequestParam String password) {
        UserLoginDetails user = userLoginDetailsRepo.findByMobileNumberAndPassword(mobileNumber,password);
        if(user==null) {
        	return ResponseEntity.ok(Map.of(
                    "message", "Please login with valid credentails",
                    "mobileNumber", user.getMobileNumber()));
        }
        
        return ResponseEntity.ok(Map.of(
                "message", "Login successful",
                "mobileNumber", user.getMobileNumber()
        ));
    }

    // Save new user login details
    @PostMapping("/")
    public ResponseEntity<Object> saveUserLoginDetails(@RequestBody UserLoginDetails userLoginDetails) {
        if (userLoginDetails.getMobileNumber() == null || userLoginDetails.getPassword() == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Mobile number and password are required"));
        }

        // Check if user exists
        if (userLoginDetailsRepo.findByMobileNumber(userLoginDetails.getMobileNumber()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Mobile number already registered"));
        }

        // Encode password before saving
      //  userLoginDetails.setPassword(encoder.encode(userLoginDetails.getPassword()));
        UserLoginDetails savedUser = userLoginDetailsRepo.save(userLoginDetails);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    // Update existing user password
    @PutMapping("/")
    public ResponseEntity<Object> updateUserLoginDetails(@RequestParam String mobileNumber, @RequestParam String password) {
        UserLoginDetails user = userLoginDetailsRepo.findByMobileNumber(mobileNumber);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "User not found"));
        }
        user.setMobileNumber(mobileNumber);
        user.setPassword(password);
        UserLoginDetails savedUser = userLoginDetailsRepo.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
