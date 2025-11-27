package com.example.IRTC.booking.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IRTC.booking.Repositories.SeatAvailabilityRepository;
import com.example.IRTC.booking.model.SeatAvailability;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvailabilityService {

	@Autowired
    private  SeatAvailabilityRepository repo ;

    public int checkAvailability(String trainNo, LocalDate date, String cls, String quota) {

        SeatAvailability s = repo.findByTrainNoAndDateAndTrainClassAndQuota(
                trainNo, date, cls, quota
        );

        if (s == null)
            return 0;

        return s.getTotalSeats() - s.getBookedSeats();
    }

    public void bookSeats(String trainNo, LocalDate date, String cls, String quota, int seats) {

        SeatAvailability s = repo.findByTrainNoAndDateAndTrainClassAndQuota(
                trainNo, date, cls, quota
        );

        s.setBookedSeats(s.getBookedSeats() + seats);

        repo.save(s);
    }
}
