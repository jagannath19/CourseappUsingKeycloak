/**
 * 
 */
package com.courseapp.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseapp.exception.IdNotFoundException;
import com.courseapp.model.Course;
import com.courseapp.service.ICourseService;

/**
 * @author JagannathSutar Controller class for course
 */
@RestController
@RequestMapping("course-serv")
public class CourseController {
	private Logger logger = LoggerFactory.getLogger(CourseController.class);

	private ICourseService courseService;

	/**
	 * @param courseService authowire ICourseService
	 */
	@Autowired
	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	/**
	 * @param course
	 * @return http status for addCourse controller for addCourse
	 * Allow role for only ADMIN
	 * 
	 */
	@RolesAllowed("ADMIN")
	@PostMapping("/addCourse")
	ResponseEntity<Void> addCourse(@RequestBody Course course) {

		logger.info("Adding one Course " + course);
		courseService.addCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	/**
	 * @param course
	 * @return http status for updateCourse
	 * Use for update the course fee using course id
	 */
	@RolesAllowed("ADMIN")
	@PutMapping("/updateCourse/id/{id}/fee/{fee}")
	ResponseEntity<Void> updateCourse(@PathVariable("id")int id,@PathVariable("fee")double fee) throws IdNotFoundException{
		

		Course course=courseService.getById(id);
		if(course==null) {
			logger.warn("No course found for id-"+id);
			throw new IdNotFoundException("No course Found ");
		}
		course.setFee(fee);
		courseService.updateCourse(course);
		
		
		return ResponseEntity.ok().build();
	}

	/**
	 * @param couseId
	 * Allow role for only ADMIN
	 */
	@RolesAllowed("ADMIN")
	@DeleteMapping("/deleteCourse/{courseId}")
	void deleteCourse(@PathVariable("courseId") int couseId) {
		logger.info("Course deleted");
		courseService.deleteCourse(couseId);

	}

	/**
	 * @return list of course
	 * Allow role for ADMIN and USER
	 */
	@RolesAllowed({ "USER", "ADMIN" })
	@GetMapping("/courses")
	ResponseEntity<List<Course>> getAll() {
		logger.info("Showing all Courses");
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "It returns all the courses");
		List<Course> courses = courseService.getAllCourse();
		ResponseEntity<List<Course>> responseEntity = new ResponseEntity<List<Course>>(courses, header, HttpStatus.OK);
		return responseEntity;
	}

	/**
	 * @param courseId
	 * @return One course object
	 * Allow role for only ADMIN
	 */
	@RolesAllowed("ADMIN")
	@GetMapping("/course/{courseId}")
	ResponseEntity<Course> getCourseById(@PathVariable("courseId") int courseId) {
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "get course by Id");
		return ResponseEntity.ok().headers(header).body(courseService.getById(courseId));
	}

}
