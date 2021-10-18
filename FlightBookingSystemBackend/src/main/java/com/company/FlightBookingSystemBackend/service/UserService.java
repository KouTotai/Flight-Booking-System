package com.company.FlightBookingSystemBackend.service;

import com.company.FlightBookingSystemBackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User validateUser(String emailAdd,String password);
    public User addUser(User user);
    public User removeUser(User user);
}
