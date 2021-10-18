package com.company.FlightBookingSystemBackend.controller;

import com.company.FlightBookingSystemBackend.model.Admin;
import com.company.FlightBookingSystemBackend.service.AdminService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/welcome")
    public String admin(){
        return ("<h1> Welcome Admin</h1>");
    }

    @ApiOperation("Add a new Admin")
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin) {
        Admin adminNew = adminService.addAdmin(admin);
        log.info("Added a new Admin");
        return new ResponseEntity<>(adminNew, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> validateAdmin(@RequestBody String userName, String password) {
        Admin admin = adminService.validateAdmin(userName, password);
        if (admin != null)
            return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(admin, HttpStatus.FORBIDDEN);
    }

    @PostMapping("/remove")
    public ResponseEntity<Admin> removeUser(@RequestBody Admin admin) {
        Admin adminRemoved = adminService.deleteAdmin(admin);
        if (adminRemoved != null)
            return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(admin, HttpStatus.FORBIDDEN);
    }

}
