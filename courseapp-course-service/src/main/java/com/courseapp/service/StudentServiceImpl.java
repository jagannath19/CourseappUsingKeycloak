/**
 * 
 */
package com.courseapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.exception.IdNotFoundException;
import com.courseapp.exception.StudentNotFoundException;
import com.courseapp.model.Student;
import com.courseapp.repository.IStudentRepository;

/**
 * @author JagannathSutar
 *
 */
@Service
public class StudentServiceImpl implements IStudentService {

	private IStudentRepository studentRepository;
	@Autowired
	public void setStudentRepository(IStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	/**
	 * This method use for add new Student
	 */
	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	/**
	 *	This method use to update an existing student
	 */
	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}

	/**
	 *	This method use to delete a student by student id
	 */
	@Override
	public void deleteStudent(int studentId) {
		
		Student student=studentRepository.findById(studentId).get();
		if(student==null) {
			logger.info("No student found for Id-"+studentId);
			throw new IdNotFoundException();
		}
		studentRepository.deleteById(studentId);
	}

	/**
	 *	This method use to get all students
	 */
	@Override
	public List<Student> getAllStudent() throws StudentNotFoundException{
		List<Student> students=studentRepository.findAll();
		if(students.isEmpty()) {
			logger.info("No Student found");
			throw new StudentNotFoundException();
		}
		else
			return students;
	}

	/**
	 *	This method use to get a student by student id
	 */
	@Override
	public Student getById(Integer studentId) {
		Student student=studentRepository.findById(studentId).get();
		if(student==null) {
			logger.info("No student found for Id-"+studentId);
			throw new IdNotFoundException();
		}
		return student;
	}

}
