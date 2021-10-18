package com.company.FlightBookingSystemBackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "flight_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 2,max = 20)
    @NotNull(message = "Please Enter Your First Name")
    private String firstName;
    @Size(min = 2,max = 20)
    @NotNull(message = "Please Enter Your Last Name")
    private String lastName;
    @NotNull(message = "Please Enter Your Email")
    @Email
    private String emailAdd;
    @NotNull(message = "Please Enter Your Mobile No")
    private String phoneNo;
    @NotNull
    private String password;

    public User(String firstName, String lastName, String emailAdd, String phoneNo, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdd = emailAdd;
        this.phoneNo = phoneNo;
        this.password = password;
    }
}
