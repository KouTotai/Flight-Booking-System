package com.company.FlightBookingSystemBackend.repository;

import com.company.FlightBookingSystemBackend.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking,Integer>{
}
