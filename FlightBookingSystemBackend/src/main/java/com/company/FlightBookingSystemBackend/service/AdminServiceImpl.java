package com.company.FlightBookingSystemBackend.service;

import com.company.FlightBookingSystemBackend.Exception.AdminNotFoundException;
import com.company.FlightBookingSystemBackend.model.Admin;
import com.company.FlightBookingSystemBackend.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    private Admin admin;

    @Override
    public Admin validateAdmin(String userName,String password){
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setPassword(password);
        try {
            if (adminRepository.exists(Example.of(admin)))
                return admin;
            else
                throw new AdminNotFoundException("Admin not found");

        } catch (AdminNotFoundException e) {
            log.info(e.getMessage());
            return null;
        }
    }
    @Override
    public Admin addAdmin(Admin admin){
        adminRepository.save(admin);
        return admin;
    }

    @Override
    public Admin deleteAdmin(Admin admin){
        Optional<Admin> userTemp = adminRepository.findById(admin.getId());
        if (userTemp.isPresent()) {
            adminRepository.deleteById(admin.getId());
            return admin;
        } else
            return null;
    }
}

