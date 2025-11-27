package com.example.IRTC.booking.Repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IRTC.booking.model.SeatAvailability;

public interface SeatAvailabilityRepository extends JpaRepository<SeatAvailability, Long> {

    SeatAvailability findByTrainNoAndDateAndTrainClassAndQuota(
        String trainNo, LocalDate date, String trainClass, String quota
    );
}
