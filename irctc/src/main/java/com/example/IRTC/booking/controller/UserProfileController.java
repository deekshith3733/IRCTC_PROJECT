package com.example.IRTC.booking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.IRTC.booking.Repositories.UserProfileRepository;
import com.example.IRTC.booking.model.UserProfile;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepo;

    @GetMapping("/{profileId}")
    public ResponseEntity<Object> getProfileDetailsByUserName(@PathVariable Integer profileId) {

        UserProfile userProfile = userProfileRepo.findById(profileId).orElse(null);

        if (userProfile == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Profile not found"));
        }

        return ResponseEntity.ok(userProfile);
    }


    @PostMapping("/")
    public ResponseEntity<Object> uploadProfileDetails(@RequestBody UserProfile userProfile) {

        if (userProfile.userFullName== null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "User name cannot be null"));
        }

        userProfile.setIsactive(true); // default active
        UserProfile saved = userProfileRepo.save(userProfile);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/")
    public ResponseEntity<Object> updateProfileDetails(@RequestBody UserProfile userProfile) {

        if (userProfile.getUserProfileId() == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Profile ID is required for update"));
        }

        UserProfile existing = userProfileRepo.findById(userProfile.getUserProfileId()).orElse(null);

        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Profile not found"));
        }

        // Update allowed fields
        existing.setUserFullName(userProfile.getUserFullName());
        existing.setIsactive(userProfile.getIsactive());

        userProfileRepo.save(existing);

        return ResponseEntity.ok(Map.of(
                "message", "Profile updated successfully",
                "profileId", existing.getUserProfileId()
        ));
    }


    @DeleteMapping("/")
    public ResponseEntity<Object> softDeleteProfileDetails(@RequestParam Integer userProfileId) {

        UserProfile profile = userProfileRepo.findById(userProfileId).orElse(null);

        if (profile == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Profile not found"));
        }

        profile.setIsactive(false);  // Soft delete
        userProfileRepo.save(profile);

        return ResponseEntity.ok(Map.of(
                "message", "Profile deactivated successfully",
                "profileId", userProfileId
        ));
    }
}
