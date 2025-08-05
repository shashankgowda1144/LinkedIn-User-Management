package com.google.linkedin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.google.linkedin.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//method name convention
	List<User> findByName(String name);

	//custom query
//	@Query("select u from User u where user.name=?1")
//	List<User> findUserByName(String name);


}