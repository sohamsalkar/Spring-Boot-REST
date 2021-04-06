package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/courses/{courseId}")
	public Courses getSingleCourse(@PathVariable String courseId) 
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) 
	{
		return this.courseService.addCourse(course);
	
	}
	

}
