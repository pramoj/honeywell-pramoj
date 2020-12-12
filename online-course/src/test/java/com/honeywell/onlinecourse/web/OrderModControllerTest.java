
package com.honeywell.onlinecourse.web;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.honeywell.onlinecourse.dto.CourseDto;
import com.honeywell.onlinecourse.exception.RecordNotFoundException;



@WebMvcTest(value = AdminController.class)
public class OrderModControllerTest {
	
	@InjectMocks
	private AdminController mockController;
	
	//@Test
    public void testInitiateStartCall() throws RecordNotFoundException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<List<CourseDto>> response = mockController.getAllCourses();
        
    }
}