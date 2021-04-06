package com.springrest.springrest.services;
import com.springrest.springrest.entities.Courses;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Courses> list;
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Courses( 10 , "java CORE" , "this is java core course" ) );
		list.add(new Courses( 20 , "python CORE" , "this is python core course" ) );
		list.add(new Courses( 30 , "ruby CORE" , "this is ruby core course" ) );
		list.add(new Courses( 40 , "java ADVANCE" , "this is java advance course" ) );
	}
	
	@Override
	public List<Courses> getCourse()
	{
		return list;	
	}

	@Override
	public Courses getCourse(long courseId) {
		Courses c = null;
		for(Courses course: list)
		{
			if(course.getId()== courseId) {
				c=course;
				break;
			}
		}
		return c ;
	}

	@Override
	public Courses addCourse(Courses course) {
		list.add(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		list.forEach(e -> {
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription() );
			}
		});
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}

	
	
}
