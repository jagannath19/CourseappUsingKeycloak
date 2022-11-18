/**
 * 
 */
package com.courseapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author JagannathSutar
 *	Model class of Student
 */
@Entity
public class Student {

	@Id
	@GeneratedValue(generator = "speciality_gen")
	@SequenceGenerator(name="speciality_gen",sequenceName = "speciality_seq",initialValue = 1,allocationSize = 1)
	private Integer studentId;
	
	private String studentName;
	
	private String studentEmail;
	
	private long studentPhone;
	
	@ManyToMany(mappedBy = "students")
	@JsonIgnore
	private Set<Course> courses;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentName, String studentEmail, long studentPhone) {
		super();
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudetnEmail(String studetnEmail) {
		this.studentEmail = studetnEmail;
	}

	public long getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(long studentPhone) {
		this.studentPhone = studentPhone;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentPhone=" + studentPhone + "]";
	}
	
	
}
