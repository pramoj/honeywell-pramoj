/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.onlinecourse.dto.EnrollCandidateDto;
import com.honeywell.onlinecourse.model.EnrollCandidateEntity;
import com.honeywell.onlinecourse.service.EnrollCandidateService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/v1/api/enroll")
@Slf4j
public class EnrollmentController {
	
	@Autowired
	EnrollCandidateService service;

	@PostMapping
	public ResponseEntity<EnrollCandidateEntity> createCourse(EnrollCandidateDto enrollCandidateDto) {
		EnrollCandidateEntity updated = service.createEnroll(enrollCandidateDto);
		return new ResponseEntity<EnrollCandidateEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}


}