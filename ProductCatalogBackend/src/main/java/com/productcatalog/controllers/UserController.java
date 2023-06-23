package com.productcatalog.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.entities.User;
import com.productcatalog.repo.UserRepo;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepo repo;

	//	Method to add a new User
	@PostMapping(path = "/user", consumes = { "application/json" })
	public ResponseEntity<String> addUser(@RequestBody User user) {
		Optional<User> existingUser = repo.findById(user.getEmail());
		if (existingUser.isPresent()) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"User already exists.\"}"); 
		}
		repo.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"User added successfully.\"}"); 
	}

	//	Method to save and update the user
	@PutMapping(path = "/user", consumes = { "application/json" })
	public ResponseEntity<String> saveOrUpdateUser(@RequestBody User user) {
		Optional<User> existingUser = repo.findById(user.getEmail());
		if (!existingUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"User not found.\"}");
		}
		repo.save(user);
		return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"User updated successfully.\"}"); 
	}

	//	Method to get list of all users
	@GetMapping(path = "/user")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	//	Method to get the user by Email
	@GetMapping("/user/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
		Optional<User> user = repo.findById(email);
		if (user.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(user.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	//	Method to delete the user by Email
	@DeleteMapping("/user/{email}")
	public ResponseEntity<String> deleteUserByEmail(@PathVariable("email") String email) {
		Optional<User> user = repo.findById(email);
		if (user.isPresent()) {
			repo.delete(user.get());
			return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
	}

	//	Method to login the user
	@PostMapping(path = "/login", consumes = { "application/json" })
	public ResponseEntity<String> login(@RequestBody User user) {
		Optional<User> existingUser = repo.findById(user.getEmail());
		if (existingUser.isPresent()) {
			User storedUser = existingUser.get();
			System.out.println(user);
			if (storedUser.getPass().equals(user.getPass())) {
				return ResponseEntity.ok().body("{\"message\": \"Login successful.\"}");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Invalid password.\"}");
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Invalid email.\"}");
		}
	}
}
