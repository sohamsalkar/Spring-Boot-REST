package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;

import com.springrest.springrest.services.CourseService;
import java.util.List;

@RestController
public class MyController 
{
	
	@Autowired 
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return " welcome at courses ";
	}
	
	//get all courses
	@GetMapping("/courses")
	public List<Courses> getCourse()
	{
		return this.courseService.getCourse();
	}
	
	//get single course
	@GetMapping("/courses/{courseId}")
	public Courses getSingleCourse(@PathVariable String courseId) 
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	
	//post a course
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) 
	{
		return this.courseService.addCourse(course);
	
	}
	
	//update course using put 
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course )
	{
		return this.courseService.updateCourse(course);
	}
	
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try
		{
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
	
