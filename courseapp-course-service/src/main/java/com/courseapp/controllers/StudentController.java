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
import com.courseapp.model.Student;
import com.courseapp.service.IStudentService;

/**
 * @author JagannathSutar
 * Controller class for Student
 *
 */
@RestController
@RequestMapping("course-serv")
public class StudentController {
	
	private IStudentService studentService;
	
	/**
	 * @param studentService
	 * autowire IStudentService
	 */
	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	private Logger logger = LoggerFactory.getLogger(StudentController.class);

	/**
	 * @param student
	 * @return http status for addStudent
	 * Allow role for only ADMIN
	 */
	@RolesAllowed("ADMIN")
	@PostMapping("/addStudent")
	ResponseEntity<Void> addStudent(@RequestBody Student student) {

		logger.info("Adding one Course " + student);
		studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	/**
	 * @param student
	 * @return http status for update student
	 * Allow role for only ADMIN
	 */
	@RolesAllowed("ADMIN")
	@PutMapping("/updateStudent/id/{id}/email/{email}")
	ResponseEntity<Void> updateCourse(@PathVariable("id")int id,@PathVariable("email")String email) {
		

		Student student=studentService.getById(id);
		if(student==null) {
			logger.warn("No student found for id-"+id);
			throw new IdNotFoundException("No student Found ");
		}
		student.setStudetnEmail(email);
		studentService.updateStudent(student);
		
		
		return ResponseEntity.ok().build();
	}
	
	/**
	 * @param studentId
	 * Allow role for only ADMIN
	 */
	@RolesAllowed("ADMIN")
	@DeleteMapping("/deleteStudent/{studentId}")
	void deleteStudent(@PathVariable("studentId")int studentId){
		logger.info("Student deleted");
		studentService.deleteStudent(studentId);
		
	}
	
	/**
	 * @return all students
	 * Allow role for only USER
	 */
	@RolesAllowed("USER")
	@GetMapping("/students")
	ResponseEntity<List<Student>> getAll(){
		logger.info("Showing all Students");
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "It returns all the students");
		List<Student> students=studentService.getAllStudent();
		ResponseEntity<List<Student>> responseEntity=new ResponseEntity<List<Student>>(students,header,HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * @param studentId
	 * @return one student object
	 * Allow role for only USER
	 */
	@RolesAllowed("USER")
	@GetMapping("/student/{studentId}")
	ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId) {
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "get student by Id");
		return ResponseEntity.ok().headers(header).body(studentService.getById(studentId));
	}

}
