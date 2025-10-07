package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modal.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
	private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User loggedInUser = service.login(user.getEmail(), user.getPassword());
            return ResponseEntity.ok(loggedInUser); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(401) // Unauthorized
                    .body(e.getMessage()); // "Invalid email or password"
        }
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        try {
            service.signup(user);
            return "Signup successful! Welcome " + user.getUsername();
        } catch (RuntimeException e) {
            return e.getMessage(); // e.g., "Email already exists"
        }
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

}
