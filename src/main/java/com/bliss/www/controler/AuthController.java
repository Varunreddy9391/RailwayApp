package com.bliss.www.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bliss.www.model.User;
import com.bliss.www.service.UserService;

@CrossOrigin(origins = "https://hostel-management-system1.netlify.app/")
@ComponentScan(basePackages = {"com.bliss.www.controller", "com.bliss.www.service"})
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = userService.loginByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.status(401).body(null); // Unauthorized
        }
    }
    @PutMapping("/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody User request) {
        try {
            // Validate and update password logic
            boolean success = userService.updatePassword(request.getUsername(), request.getPassword());
            if (success) {
                return ResponseEntity.ok("Password updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
            }
        } catch (Exception e) {
            // Log and handle the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
    
}
