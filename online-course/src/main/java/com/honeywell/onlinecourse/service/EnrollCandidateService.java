/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.onlinecourse.dto.EnrollCandidateDto;
import com.honeywell.onlinecourse.exception.RecordNotFoundException;
import com.honeywell.onlinecourse.model.CourseEntity;
import com.honeywell.onlinecourse.model.EnrollCandidateEntity;
import com.honeywell.onlinecourse.repository.CourseRepository;
import com.honeywell.onlinecourse.repository.EnrollCandidateRepository;

@Service
public class EnrollCandidateService {

	@Autowired
	EnrollCandidateRepository repository;
	
	CourseRepository courseRepository;
	
	public EnrollCandidateEntity createEnroll(EnrollCandidateDto enrollCandidateDto) throws RecordNotFoundException {
		
		EnrollCandidateEntity entity=new EnrollCandidateEntity();
		
		entity.setCandidateEnrollStart(new Date());
		entity.setCandidateName(enrollCandidateDto.getCandidateName());
		
		Optional<CourseEntity> course = courseRepository.findById(enrollCandidateDto.getCourseId());

		if (course.isPresent()) {
			entity.setCourse(course.get());
		}
		else
		{
			throw new RecordNotFoundException("Course Not Found");
		}
		entity = repository.save(entity);
	
		return entity;

	}

	
}