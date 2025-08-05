package com.google.linkedin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.linkedin.entity.User;
import com.google.linkedin.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping("/users")
	public ResponseEntity<?> saveUser(@RequestBody User u){
		return service.saveUser(u);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> findAllUser(){
		return service.findAllUser();
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id) {
		return service.findUserById(id);
	}
	
	@GetMapping("/users/name/{name}")
	public ResponseEntity<?> findUserByName(@PathVariable String name){
		return service.findUserByName(name);
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable int id) {
		return service.deleteUserById(id);
	}
	

}