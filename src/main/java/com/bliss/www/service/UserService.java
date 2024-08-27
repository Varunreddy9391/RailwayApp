package com.bliss.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bliss.www.model.User;
import com.bliss.www.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Implement any additional logic, like password encoding
        return userRepository.save(user);
    }

    public User loginByUsername(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user; // Passwords match
        }
        return null; // User not found or password mismatch
    }

    public User loginByPhoneNumber(String phoneNumber, String password) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User loginByEmail(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User loginByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    public boolean updatePassword(String username, String newPassword) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setPassword(newPassword);
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
    private boolean isPasswordValid(User user, String currentPassword) {
        // Validate the current password (e.g., hash comparison)
        return user.getPassword().equals(currentPassword); // Simplified for example
    }
}
