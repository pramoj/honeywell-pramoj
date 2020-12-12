/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeywell.onlinecourse.dto.CourseDto;
import com.honeywell.onlinecourse.exception.RecordNotFoundException;
import com.honeywell.onlinecourse.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/v1/api/Courses")
@Slf4j
public class AdminController {
	@Autowired
	CourseService service;

	@GetMapping
	public ResponseEntity<List<CourseDto>> getAllCourses() throws RecordNotFoundException {
		List<CourseDto> list = service.getAllCourses();

		return new ResponseEntity<List<CourseDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") Long id) throws RecordNotFoundException {
		CourseDto entity = service.getCourseById(id);

		return new ResponseEntity<CourseDto>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CourseDto> createCourse(CourseDto Course) {
		CourseDto updated = service.createCourse(Course);
		return new ResponseEntity<CourseDto>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<CourseDto> updateCourse(CourseDto Course) throws RecordNotFoundException {
		CourseDto updated = service.updateCourse(Course);
		return new ResponseEntity<CourseDto>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteCourseById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteCourseById(id);
		return HttpStatus.FORBIDDEN;
	}

}