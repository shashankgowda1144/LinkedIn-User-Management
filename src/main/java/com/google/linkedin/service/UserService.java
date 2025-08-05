package com.google.linkedin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.linkedin.dao.UserDao;
import com.google.linkedin.entity.User;
import com.google.linkedin.responsestructure.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public ResponseEntity<?> saveUser(User u) {
		User savedUser = dao.saveUser(u);
		ResponseStructure rs = new ResponseStructure(201, "User Saved Successfully", savedUser);
		return ResponseEntity.status(201).body(rs);
	}

	public ResponseEntity<?> findUserById(int id) {
		Optional<User> optional = dao.findUserById(id);

		if (optional.isPresent()) {
			User u = optional.get();
			ResponseStructure rs = new ResponseStructure(200, "User Found Successfully", u);
			return ResponseEntity.status(200).body(rs);
		} else {
			ResponseStructure rs = new ResponseStructure(404, "Invalid User Id, Unabe to find User", "User Not Found");
			return ResponseEntity.status(404).body(rs);
		}
	}

	public ResponseEntity<?> findAllUser() {
		List<User> ul = dao.findAllUser();
		ResponseStructure rs = new ResponseStructure(200, "All User Found Successfully", ul);
			return ResponseEntity.status(200).body(rs);
	}

	
	public ResponseEntity<?> findUserByName(String name) {
		List<User> ul = dao.findUserByName(name);
		ResponseStructure rs = new ResponseStructure(200, "All the User with "+name+"Found Successfully", ul);
		return ResponseEntity.status(200).body(rs);
	}

	public String deleteUserById(int id) {
		dao.deleteUserById(id);
		return "User Deleted Successfully";
	}

}