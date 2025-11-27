package com.example.IRTC.booking.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.IRTC.booking.Repositories.TrainRepository;
import com.example.IRTC.booking.model.Train;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainService {

    private final TrainRepository trainRepo = null;

    public List<Train> searchTrains(String source, String destination) {
        return trainRepo.findAll().stream()
                .filter(t -> t.getRoute().stream().anyMatch(r -> r.getStation().equals(source)))
                .filter(t -> t.getRoute().stream().anyMatch(r -> r.getStation().equals(destination)))
                .toList();
    }
}
