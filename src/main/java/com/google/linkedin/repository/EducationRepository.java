package com.google.linkedin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.google.linkedin.entity.Education;

public interface EducationRepository extends JpaRepository<Education, Integer> {

	@Query("select e  from Education e where e.user.id=?1")
	List<Education> findAllEducationBYUserId(int uid);


}