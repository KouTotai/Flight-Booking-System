package com.company.FlightBookingSystemBackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Enter the username")
    private String userName;

    @NotNull(message = "Enter the password")
    private String password;

    public Admin(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
