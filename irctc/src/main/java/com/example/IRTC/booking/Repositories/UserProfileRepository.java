package com.example.IRTC.booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.IRTC.booking.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
