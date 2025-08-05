package com.google.linkedin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.linkedin.dao.EducationDao;
import com.google.linkedin.dao.UserDao;
import com.google.linkedin.entity.Education;
import com.google.linkedin.entity.User;
import com.google.linkedin.responsestructure.ResponseStructure;

@Service
public class EducationService 
{
	@Autowired
	EducationDao educationDao;
	@Autowired
	UserDao userDao;

	public ResponseEntity<?> saveEducation(Education e, int uid) 
	{
		Optional<User> optional = userDao.findUserById(uid);
		
		if (optional.isPresent()) 
		{
			User u = optional.get();
			e.setUser(u);
			Education savedEducation = educationDao.saveEducation(e);
			ResponseStructure rs = new ResponseStructure(201, "Education Saved Successfully for " + u.getName(),savedEducation);
			return ResponseEntity.status(201).body(rs);
		} 
		else 
		{
			ResponseStructure rs = new ResponseStructure(400, "Invalid User ID, Unable to save education","Education Not Saved");
			return ResponseEntity.status(400).body(rs);
		}
	}
	
	
	public ResponseEntity<?> findAllEducations() {
		List<Education> el = educationDao.findAllEducations();
		ResponseStructure rs = new ResponseStructure(200, "All Educatons Found Successfully", el);
		return ResponseEntity.status(200).body(rs);
	}

	
	public ResponseEntity<?> findAllEducationsByUserId(int uid) {
		List<Education> el = educationDao.findAllEducationsByUserId(uid);
		ResponseStructure rs = new ResponseStructure(200, "All Educations of The User Found Successfully", el);
		return ResponseEntity.status(200).body(rs);
	}
	public String deleteEducationByUserId(int uid) {
		educationDao.deleteEducationByUserId(uid);
		return "Education is deleted By User Id";
	}
}