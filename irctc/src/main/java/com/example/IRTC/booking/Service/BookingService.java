

package com.example.IRTC.booking.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IRTC.booking.DTO.BookingRequest;
import com.example.IRTC.booking.Repositories.BookingRepository;
import com.example.IRTC.booking.Repositories.UserRepository;
import com.example.IRTC.booking.model.Booking;
import com.example.IRTC.booking.model.Passenger;
import com.example.IRTC.booking.model.PassengerBooking;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

	@Autowired
    private  AvailabilityService availabilityService ;
    private  BookingRepository bookingRepo ;
    private  UserRepository userRepo ;

    public Booking createBooking(Long userId, BookingRequest req) {

        // Check availability
        int available = availabilityService.checkAvailability(
                req.getTrainNo(), req.getDate(), req.getCls(), req.getQuota());

        if (available < req.getPassengers().size()) {
            throw new RuntimeException("Not enough seats!");
        }

        // Deduct seats
        availabilityService.bookSeats(
                req.getTrainNo(), req.getDate(), req.getCls(), req.getQuota(),
                req.getPassengers().size()
        );

        // Create booking entity
        Booking booking = new Booking();
        booking.setPnr("PNR" + System.currentTimeMillis());
        booking.setTrainNo(req.getTrainNo());
        booking.setDate(req.getDate());
        booking.setStatus("CONFIRMED");
        booking.setPaymentStatus("PAID");
        booking.setUser(userRepo.findById(userId).orElseThrow());

        // Allocate seats
        List<PassengerBooking> pb = new ArrayList<>();
        int seatCounter = 1;

        for (Passenger p : req.getPassengers()) {
            PassengerBooking b = new PassengerBooking();
            b.setName(p.getName());
            b.setAge(p.getAge());
            b.setGender(p.getGender());
            b.setBerthPreference(p.getBerthPreference());
            b.setSeatAllocated("S" + seatCounter++);
            pb.add(b);
        }

        booking.setPassengerDetails(pb);

        return bookingRepo.save(booking);
    }
}
