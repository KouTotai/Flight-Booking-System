package com.company.FlightBookingSystemBackend.service;

import com.company.FlightBookingSystemBackend.Exception.FlightBookingNotFoundException;
import com.company.FlightBookingSystemBackend.model.FlightBooking;
import com.company.FlightBookingSystemBackend.repository.FlightBookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FlightBookingServiceImpl implements FlightBookingService{

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @Override
    public List<FlightBooking> getAll(){
        return flightBookingRepository.findAll();
    }

    @Override
    public FlightBooking addFlightBooking(FlightBooking flightBooking){
        flightBookingRepository.save(flightBooking);
        return flightBooking;
    }

    @Override
    public FlightBooking fetchById(int id){
        Optional<FlightBooking> optionalFlightBooking = flightBookingRepository.findById(id);
        if(optionalFlightBooking.isPresent())
            return optionalFlightBooking.get();
        return null;
    }

    @Override
    public FlightBooking updateFlightBooking(int id,FlightBooking flightBooking){
        FlightBooking fb = null;
        try {
            Optional<FlightBooking> optionalFlightBooking = flightBookingRepository.findById(id);
            if (optionalFlightBooking.isPresent())
                fb = optionalFlightBooking.get();
            else{
                throw new FlightBookingNotFoundException("Flight not found");
            }
            fb.setPassenger_cnt(flightBooking.getPassenger_cnt());

            return flightBooking;
        }catch(FlightBookingNotFoundException e){
            return flightBooking;
        }
    }

    @Override
    public void deleteFlightBooking(int id){
        flightBookingRepository.deleteById(id);
    }
}
