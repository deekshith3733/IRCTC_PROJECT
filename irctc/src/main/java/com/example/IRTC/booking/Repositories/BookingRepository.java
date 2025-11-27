package com.example.IRTC.booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.IRTC.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByPnr(String pnr);
}
