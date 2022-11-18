/**
 * 
 */
package com.courseapp.service;

import java.util.List;

import com.courseapp.model.Student;

/**
 * @author JagannathSutar
 *	Interface for student service
 */
public interface IStudentService {
	void addStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(int studentId);

	List<Student> getAllStudent();

	Student getById(Integer studentId);

}
