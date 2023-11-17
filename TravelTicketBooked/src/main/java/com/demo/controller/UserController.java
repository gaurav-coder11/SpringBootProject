package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.exceptions.UserNotFoundException;
import com.demo.repository.UserRepository;
import com.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public UserRepository userRepo;
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/showUsers")
	public List<User> showUsers() {
		return userRepo.findAll();
	}
//    @PostMapping("/signup")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User existingUser = userService.findByEmail(user.getEmail());
//        if (existingUser != null) {
//            return ResponseEntity.badRequest().build(); // Return any error response
//        }
//        User savedUser = userService.saveUser(user);
//        return ResponseEntity.ok(savedUser);
//    }

	@PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(userId, user);
            return ResponseEntity.ok(updatedUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
	    userService.deleteUser(userId);
	    String message = "User Delete";
	    return ResponseEntity.ok(message);
	}
	

	@PostMapping("/signuP")
	public ResponseEntity<String> signUp(@RequestBody User user) {
		if (userRepo.findByUsername(user.getUsername()) != null) {
			return ResponseEntity.badRequest().body("Username already exists");
		}
		userRepo.save(user);
		return ResponseEntity.ok("Signed up successfully");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		User existingUser = userRepo.findByUsername(user.getUsername());
		if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		}
		return ResponseEntity.ok("Login successful");
	}
}
