/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.honeywell.onlinecourse.model.CourseEntity;


@Repository
public interface CourseRepository
        extends JpaRepository<CourseEntity, Long> {
 
}
