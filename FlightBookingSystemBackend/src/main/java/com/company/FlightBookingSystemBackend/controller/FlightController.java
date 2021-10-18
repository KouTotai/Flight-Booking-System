package com.company.FlightBookingSystemBackend.controller;

import com.company.FlightBookingSystemBackend.model.Flight;
import com.company.FlightBookingSystemBackend.service.FlightService;
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
@RequestMapping("Flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @ApiOperation("Get all the Flight")
    @GetMapping("/getall")
    public List<Flight> getAllFlight(){
        log.info("Fetch all the Flights");
        return flightService.getAll();
    }

    @ApiOperation("Add new Flight")
    @PostMapping("/addFlight")
    public ResponseEntity<Flight> addNewTest(@Valid @RequestBody Flight flight){
        Flight newFlight = flightService.addFlight(flight);
        log.info("Added new Flight");
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @ApiOperation("Get Flight by Id")
    @GetMapping("/getFlight/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable int id){
        return ResponseEntity.ok(this.flightService.fetchById(id));
    }

    @ApiOperation("Update Flight")
    @PutMapping("/updateFlight/{id}")
    public ResponseEntity<Flight> updateFlightDetails(@PathVariable int id,@Valid @RequestBody Flight flight){
        Flight updateFlight = flightService.updateFlight(id,flight);
        log.info("Update Flight Details");
        return new ResponseEntity<>(updateFlight,HttpStatus.ACCEPTED);
    }

    @ApiOperation("Delete Flight")
    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable int id){
        log.info("Deleting a Flight with id %d", id);
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
