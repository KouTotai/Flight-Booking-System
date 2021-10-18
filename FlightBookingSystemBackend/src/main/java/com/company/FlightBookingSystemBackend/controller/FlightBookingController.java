package com.company.FlightBookingSystemBackend.controller;

import com.company.FlightBookingSystemBackend.model.FlightBooking;
import com.company.FlightBookingSystemBackend.service.FlightBookingService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("FlightBooking")
public class FlightBookingController {

    @Autowired
    private FlightBookingService flightBookingService;

    @ApiOperation("Get all the FlightBooking")
    @GetMapping("/getall")
    public List<FlightBooking> getAllFlightBooking(){
        log.info("Fetch all the FlightBooking");
        return flightBookingService.getAll();
    }

    @ApiOperation("Add new Flight Booking")
    @PostMapping("/addFlightBooking")
    public ResponseEntity<FlightBooking> addNewTest(@Valid @RequestBody FlightBooking flightBooking){
        FlightBooking newFlightBooking = flightBookingService.addFlightBooking(flightBooking);
        log.info("Added new Flight");
        return new ResponseEntity<>(newFlightBooking, HttpStatus.CREATED);
    }

    @ApiOperation("Get Flight Booking by Id")
    @GetMapping("/getFlightBooking/{id}")
    public ResponseEntity<FlightBooking> getFlightBookingById(@PathVariable int id){
        return ResponseEntity.ok(this.flightBookingService.fetchById(id));
    }

    @ApiOperation("Update Flight Booking")
    @PutMapping("/updateFlightBooking/{id}")
    public ResponseEntity<FlightBooking> updateFlightBookingDetails(@PathVariable int id,@Valid @RequestBody FlightBooking flightBooking){
        FlightBooking updateFlightBooking = flightBookingService.updateFlightBooking(id,flightBooking);
        log.info("Update Flight Booking Details");
        return new ResponseEntity<>(updateFlightBooking,HttpStatus.ACCEPTED);
    }

    @ApiOperation("Delete Flight Booking")
    @DeleteMapping("/deleteFlightBooking/{id}")
    public ResponseEntity<Void> deleteFlightBooking(@PathVariable int id){
        log.info("Deleting a Flight with id %d", id);
        flightBookingService.deleteFlightBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
