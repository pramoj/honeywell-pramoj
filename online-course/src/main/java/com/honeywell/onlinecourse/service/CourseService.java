/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.onlinecourse.dto.CourseDto;
import com.honeywell.onlinecourse.dto.CourseMapper;
import com.honeywell.onlinecourse.exception.RecordNotFoundException;
import com.honeywell.onlinecourse.model.CourseEntity;
import com.honeywell.onlinecourse.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository repository;
	

	public List<CourseDto> getAllCourses() throws RecordNotFoundException {
		List<CourseEntity> courseList = repository.findAll();

		if (courseList.size() > 0) {
			return CourseMapper.courseMapper.toCourseDto(courseList);
		} else {
			throw new RecordNotFoundException("No Course record exist.");
		}
	}

	public CourseDto getCourseById(Long id) throws RecordNotFoundException {
		Optional<CourseEntity> course = repository.findById(id);

		if (course.isPresent()) {
			return CourseMapper.courseMapper.toCourseDto(course.get());
		} else {
			throw new RecordNotFoundException("No course record exist for given id");
		}
	}

	public CourseDto createCourse(CourseDto courseDto) {
		
		CourseEntity entity=CourseMapper.courseMapper.toCourseEntity(courseDto);
		entity = repository.save(entity);
		return CourseMapper.courseMapper.toCourseDto(entity);

	}

	public CourseDto updateCourse(CourseDto courseDto) throws RecordNotFoundException {
		Optional<CourseEntity> course = repository.findById(courseDto.getCourseId());

		if (course.isPresent()) {
			CourseEntity newEntity = course.get();
			newEntity.setCourseDuration(courseDto.getCourseDuration());
			newEntity.setCourseName(courseDto.getCourseName());
			repository.save(newEntity);
			return CourseMapper.courseMapper.toCourseDto(newEntity);
		} else {
			throw new RecordNotFoundException("Record Not Found");
		}
	}

	public void deleteCourseById(Long id) throws RecordNotFoundException {
		Optional<CourseEntity> course = repository.findById(id);

		if (course.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No course record exist for given id");
		}
	}
}