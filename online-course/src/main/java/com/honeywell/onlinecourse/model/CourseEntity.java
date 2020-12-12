/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="TBL_COURSE")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    private Long courseId;
    
    @Column(name="COURSE_NAME")
    private String courseName;
    
    @Column(name="COURSE_DURATION")
    private Integer courseDuration;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<EnrollCandidateEntity> candidate;
}