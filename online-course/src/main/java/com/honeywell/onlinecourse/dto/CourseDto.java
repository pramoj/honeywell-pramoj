/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.dto;

import lombok.Data;

@Data
public class CourseDto {

	private Long courseId;

	private String courseName;

	private Integer courseDuration;
}