package com.example.IRTC.booking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.IRTC.booking.DTO.BookingRequest;
import com.example.IRTC.booking.Service.BookingService;
import com.example.IRTC.booking.model.Booking;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
@Autowired
	private  BookingService bookingService;

    @PostMapping("/create")
    public Booking create(@RequestBody BookingRequest req) {
        return bookingService.createBooking(req.getUserId(), req);
    }
}
