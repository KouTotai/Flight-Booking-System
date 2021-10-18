package com.company.FlightBookingSystemBackend.repository;

import com.company.FlightBookingSystemBackend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {
    Optional<Flight> findById(int id);
}
