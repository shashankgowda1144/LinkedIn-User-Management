package com.google.linkedin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.linkedin.entity.User;
import com.google.linkedin.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository repository;

	public User saveUser(User u) {
		return repository.save(u);
	}

	public Optional<User> findUserById(int id) {
		return repository.findById(id);
	}


	public List<User> findUserByName(String name) {
		
		return repository.findByName(name);
	}

	public List<User> findAllUser() {
	
		return repository.findAll();

	}

	public void deleteUserById(int id) {
		repository.deleteById(id);
		
	}

}