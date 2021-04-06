package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;
import java.util.List;

@RestController
public class MyController {
	
	@Autowired 
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		
		return " welcome at courses ";
		
	}
	
	//get courses
	@GetMapping("/courses")
	public List<Courses> getCourse()
	{
		return this.courseService.getCourse();
	}
	
	
	

}
