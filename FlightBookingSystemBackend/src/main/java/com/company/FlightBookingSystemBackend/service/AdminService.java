package com.company.FlightBookingSystemBackend.service;

import com.company.FlightBookingSystemBackend.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    public Admin validateAdmin(String username,String password);
    public Admin addAdmin(Admin admin);
    public Admin deleteAdmin(Admin admin);
}
