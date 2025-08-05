package com.google.linkedin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.linkedin.entity.Education;
import com.google.linkedin.repository.EducationRepository;

@Repository
public class EducationDao {

	@Autowired
	EducationRepository repository;

	public Education saveEducation(Education e) {
		return repository.save(e);
	}

	public List<Education> findAllEducations() {
		return repository.findAll();
	}

	public List<Education> findAllEducationsByUserId(int uid) {
		
		return repository.findAllEducationBYUserId(uid);
	}

	public void deleteEducationByUserId(int uid) {
		repository.deleteById(uid);
		
	}

	

	

}