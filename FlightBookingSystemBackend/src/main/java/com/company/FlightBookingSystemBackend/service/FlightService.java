package com.company.FlightBookingSystemBackend.service;

import com.company.FlightBookingSystemBackend.model.Flight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {
    public List<Flight> getAll();
    public Flight addFlight(Flight flight);
    public Flight fetchById(int id);
    public Flight updateFlight(int id,Flight flight);
    void deleteFlight(int id);
}
