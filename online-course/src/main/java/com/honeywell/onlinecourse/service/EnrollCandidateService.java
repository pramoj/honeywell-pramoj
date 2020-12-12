/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.onlinecourse.dto.EnrollCandidateDto;
import com.honeywell.onlinecourse.model.EnrollCandidateEntity;
import com.honeywell.onlinecourse.repository.EnrollCandidateRepository;

@Service
public class EnrollCandidateService {

	@Autowired
	EnrollCandidateRepository repository;
	
	public EnrollCandidateEntity createEnroll(EnrollCandidateDto enrollCandidateDto) {
		
		EnrollCandidateEntity entity=new EnrollCandidateEntity();
		entity.getCourse().setCourseId(enrollCandidateDto.getCourseId());
		entity.setCandidateEnrollStart(new Date());
		entity = repository.save(entity);
	
		return entity;

	}

	
}