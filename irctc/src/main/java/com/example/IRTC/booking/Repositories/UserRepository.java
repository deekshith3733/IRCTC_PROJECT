package com.example.IRTC.booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IRTC.booking.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
