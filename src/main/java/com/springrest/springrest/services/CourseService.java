package com.springrest.springrest.services;
import com.springrest.springrest.entities.Courses;
import java.util.List;


public interface CourseService {
	
	public List<Courses> getCourse();


	public Courses getCourse(long courseId);
	public Courses addCourse(Courses course)
}
