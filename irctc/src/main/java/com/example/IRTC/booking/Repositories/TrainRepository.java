package com.example.IRTC.booking.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.IRTC.booking.model.Train;

public interface TrainRepository extends JpaRepository<Train, String> {
}
