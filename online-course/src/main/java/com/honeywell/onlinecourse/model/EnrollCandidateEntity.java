/*
 * Copyright (C) Honeywell
 */
package com.honeywell.onlinecourse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TBL_ENROLL_CANDIDATE")
public class EnrollCandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CANDIDATE_ID")
    private Long candidateId;
    
    @Column(name="CANDIDATE_NAME")
    private String candidateName;
    
    @Column(name="CANDIDATE_ENROLL_START")
    private Date candidateEnrollStart;
    
    @Column(name="CANDIDATE_ENROLL_END")
    private Date candidateEnrollEnd;
    
    @Column(name="CANDIDATE_GRADE")
    private String candidateGrade;
    
    @Column(name="CANDIDATE_ENROLL_COURSE")
    private String enrollCourse;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "COURSE_ID"), name = "COURSE_ID")
    private CourseEntity course;
    
}

