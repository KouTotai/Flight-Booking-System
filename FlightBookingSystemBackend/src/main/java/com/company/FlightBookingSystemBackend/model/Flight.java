package com.company.FlightBookingSystemBackend.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 2,max = 20)
    @NotNull(message = "Please Enter Your Company Name")
    private String airLine;

    @NotNull(message = "Enter departure location")
    private String depLoc;

    @NotNull(message = "Enter arrival location")
    private String arvLoc;

    @NotNull(message = "Enter departure location")
    private Date depDate;

    @NotNull(message = "Enter price")
    private int price;

    private int seatCapacity;

    public Flight(String airLine, String depLoc, String arvLoc, Date depDate, int price, int seatCapacity){
        this.airLine = airLine;
        this.depLoc = depLoc;
        this.arvLoc = arvLoc;
        this.depDate = depDate;
        this.price = price;
        this.seatCapacity = seatCapacity;
    }

}
