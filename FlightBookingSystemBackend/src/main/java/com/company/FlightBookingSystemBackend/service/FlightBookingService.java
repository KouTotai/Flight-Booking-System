package com.company.FlightBookingSystemBackend.service;

import com.company.FlightBookingSystemBackend.model.FlightBooking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightBookingService {
    public List<FlightBooking> getAll();
    public FlightBooking addFlightBooking(FlightBooking flightBooking);
    public FlightBooking fetchById(int id);
    public FlightBooking updateFlightBooking(int id,FlightBooking flightBooking);
    public void deleteFlightBooking(int id);
}
