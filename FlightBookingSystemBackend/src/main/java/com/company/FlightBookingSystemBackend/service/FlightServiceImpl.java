package com.company.FlightBookingSystemBackend.service;

import com.company.FlightBookingSystemBackend.Exception.FlightNotFoundException;
import com.company.FlightBookingSystemBackend.model.Flight;
import com.company.FlightBookingSystemBackend.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FlightServiceImpl implements FlightService{
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAll(){
        return flightRepository.findAll();
    }

    @Override
    public Flight addFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    @Override
    public Flight fetchById(int id){
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if(optionalFlight.isPresent())
            return optionalFlight.get();
        return null;
    }

    @Override
    public Flight updateFlight(int id,Flight flight){
        Flight fl = null;
        try {
            Optional<Flight> optionalFlight = flightRepository.findById(id);
            if (optionalFlight.isPresent())
                fl = optionalFlight.get();
            else{
                throw new FlightNotFoundException("Flight not found");
            }
            fl.setAirLine(flight.getAirLine());
            fl.setArvLoc(flight.getArvLoc());
            fl.setDepLoc(flight.getDepLoc());
            fl.setDepDate(flight.getDepDate());
            fl.setPrice(flight.getPrice());
            fl.setSeatCapacity(flight.getSeatCapacity());

            return flight;
        }catch(FlightNotFoundException e){
            return flight;
        }
    }

    @Override
    public void deleteFlight(int id){
        flightRepository.deleteById(id);
    }
}
