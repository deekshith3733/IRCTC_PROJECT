package com.example.IRTC.booking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.IRTC.booking.Service.AvailabilityService;
import com.example.IRTC.booking.Service.TrainService;
import com.example.IRTC.booking.model.Train;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/trains")
@RequiredArgsConstructor
public class TrainController {

    private final TrainService trainService = new TrainService();
    private final AvailabilityService availabilityService = new AvailabilityService();

    @GetMapping("/search")
    public List<Train> search(
            @RequestParam String source,
            @RequestParam String destination) {
        return trainService.searchTrains(source, destination);
    }

    @GetMapping("/availability")
    public int availability(
            @RequestParam String trainNo,
            @RequestParam String date,
            @RequestParam String cls,
            @RequestParam String quota) {
        return availabilityService.checkAvailability(
                trainNo, java.time.LocalDate.parse(date), cls, quota
        );
    }
}
