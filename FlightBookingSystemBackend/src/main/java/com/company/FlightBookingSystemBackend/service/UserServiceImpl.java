package com.company.FlightBookingSystemBackend.service;

import com.company.FlightBookingSystemBackend.Exception.UserNotFoundException;
import com.company.FlightBookingSystemBackend.model.User;
import com.company.FlightBookingSystemBackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private User user;

    @Override
    public User validateUser(String emailAdd, String password){
        User user = new User();
        user.setEmailAdd(emailAdd);
        user.setPassword(password);
        try {
            if (userRepository.exists(Example.of(user)))
                return user;
            else
                throw new UserNotFoundException("User not found");

        } catch (UserNotFoundException e) {
            log.info(e.getMessage());
            return null;
        }
    }
    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User removeUser(User user) {
        Optional<User> userTemp = userRepository.findById(user.getId());
        if (userTemp.isPresent()) {
            userRepository.deleteById(user.getId());
            return user;
        } else
            return null;
    }

}
