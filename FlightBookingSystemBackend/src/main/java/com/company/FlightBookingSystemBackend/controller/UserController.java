package com.company.FlightBookingSystemBackend.controller;

import com.company.FlightBookingSystemBackend.model.User;
import com.company.FlightBookingSystemBackend.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String user(){
        return ("<h1> Welcome User</h1>");
    }

    @ApiOperation("Add a new  User")
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        User userNew = userService.addUser(user);
        log.info("Added a new User");
        return new ResponseEntity<>(userNew, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> validateUser(@RequestBody String emailAdd, String password) {
        User user = userService.validateUser(emailAdd, password);
        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
    }

    @PostMapping("/remove")
    public ResponseEntity<User> removeUser(@RequestBody User user) {
        User userRemoved = userService.removeUser(user);
        if (userRemoved != null)
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
    }
}
