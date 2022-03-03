package main.java.emlakburada.controller;

import emlakburada.dto.AdvertRequest;
import emlakburada.dto.UserRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.dto.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import emlakburada.model.User;
import emlakburada.service.UserService;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest request) {

		return new ResponseEntity<>(userService.saveUser(request),HttpStatus.CREATED);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserResponse>> findAll() {
		return new ResponseEntity<>(userService.findAll(),HttpStatus.CREATED);

	}

	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<UserResponse> findByUserId(@PathVariable(required = false) int userId) {
		return new ResponseEntity<>(userService.findByUserId(userId), HttpStatus.OK);
	}


}
