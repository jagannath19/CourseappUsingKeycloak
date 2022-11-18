package com.courseapp.service;

import java.util.List;

import com.courseapp.model.Course;

public interface ICourseService {
	void addCourse(Course course);

	void updateCourse(Course course);

	void deleteCourse(int courseId);

	List<Course> getAllCourse();

	Course getById(Integer courseId);

}
