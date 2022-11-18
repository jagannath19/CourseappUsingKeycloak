/**
 * 
 */
package com.courseapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.exception.CourseNotFoundException;
import com.courseapp.exception.IdNotFoundException;
import com.courseapp.model.Course;
import com.courseapp.repository.ICourseRepository;

/**
 * @author JagannathSutar
 *	Service class of Course
 */
@Service
public class CourseServiceImpl implements ICourseService {

	
	private Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	private ICourseRepository courseRepository;
	@Autowired
	public void setCourseRepository(ICourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	
	/**
	 * 	This method use for add new Course 
	 */
	@Override
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	
	
	/**
	 *	This method use to update an existing Course
	 */
	@Override
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	/**
	 *	This method use to delete a course by course id
	 */
	@Override
	public void deleteCourse(int courseId) {
		Course course=courseRepository.findById(courseId).get();
		if(course==null) {
			logger.warn("No course found for Id-"+courseId);
			throw new IdNotFoundException("Invalid id");
		}
		else
		courseRepository.deleteById(courseId);
	}
	/**
	 *	This method use to get all courses
	 */
	@Override
	public List<Course> getAllCourse() throws CourseNotFoundException{
		List<Course> courses=courseRepository.findAll();
		if (courses.isEmpty()) {
			logger.warn("No course found");
			throw new CourseNotFoundException("No course found");
		}
		 
			return courses;
	}
	/**
	 *	This method use to get a course by course id
	 */
	@Override
	public Course getById(Integer courseId) throws IdNotFoundException{
		Course course=courseRepository.findById(courseId).get();
		if(course==null) {
			logger.warn("No course found for id- "+courseId);
			throw new IdNotFoundException();
		}
		
		return course;
	}

	

}
