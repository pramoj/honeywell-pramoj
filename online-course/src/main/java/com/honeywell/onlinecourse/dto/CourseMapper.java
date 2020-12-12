/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.honeywell.onlinecourse.model.CourseEntity;


@Mapper(unmappedSourcePolicy=ReportingPolicy.IGNORE, componentModel = "spring")
public interface CourseMapper {
	
	CourseMapper courseMapper = Mappers.getMapper(CourseMapper.class);
	CourseDto toCourseDto(CourseEntity courseEntity);
	
	List<CourseDto> toCourseDto(List<CourseEntity> courseEntityList);
	
	CourseEntity toCourseEntity(CourseDto courseDto);
	
}
