/**
 * 
 */
package com.courseapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.courseapp.model.Course;
import com.courseapp.repository.ICourseRepository;
import com.courseapp.service.ICourseService;

/**
 * @author JagannathSutar
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class CourseServiceTest {
	
	
	@MockBean
	private ICourseRepository courseRepository;

	@Autowired
	private ICourseService courseService; 
	
	
	@Test
	@DisplayName("Test Get all course ")
	public void testGetAllCourse() {
		List<Course> myCourse=new ArrayList<Course>();
		myCourse.add(new Course(1, "python", "online", 7000, 45));
		myCourse.add(new Course(2, "mangodb", "offline", 8600, 60));
		
		when(courseRepository.findAll()).thenReturn(myCourse);
		assertEquals(2, courseService.getAllCourse().size());
	}
	
	@Test
	@DisplayName("Test get By id")
	public void testGetById() {
		Course course=new Course(1, "python", "online", 7000, 45);
		int id=1;
		doReturn(course).when(courseRepository.findById(id));
		assertEquals(course, courseService.getById(id));
	}

	@Test
	public void testAddCourse() {
		Course course=new Course(1, "python", "online", 7000, 45);
		courseService.addCourse(course);
		verify(courseRepository, times(1)).save(course);
	}
	
	@Test
	public void testDeleteCourse() {
		int id=1;
		courseService.deleteCourse(id);
		verify(courseRepository,times(1)).deleteById(id);
	}
	
}
