package com.courseapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author JagannathSutar
 *	Model class of Course
 */
@Entity
public class Course {
	@Id
	@GeneratedValue(generator = "course_gen")
	@SequenceGenerator(name = "course_gen", sequenceName = "course_seq",initialValue = 100,allocationSize = 100)
	private Integer courseId;
	
	@Column(length = 20)
	private String courseName;
	
	@Column(length = 8)
	private String mode;		//online or offline
	
	private double fee;
	
	private int durationInDays;		//duration in days

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="trainer_id")
	private Trainer trainer;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "course_student", joinColumns = @JoinColumn(name="course_id"),
		inverseJoinColumns = @JoinColumn(name="student_id")
			)
	private Set<Student> students;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course( String courseName, String mode, double fee, int durationInDays, Trainer trainer) {
		super();
		this.courseName = courseName;
		this.mode = mode;
		this.fee = fee;
		this.durationInDays = durationInDays;
		this.trainer = trainer;
	}
	
	

	public Course(Integer courseId, String courseName, String mode, double fee, int durationInDays) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.mode = mode;
		this.fee = fee;
		this.durationInDays = durationInDays;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getDurationInDays() {
		return durationInDays;
	}

	public void setDurationInDays(int durationInDays) {
		this.durationInDays = durationInDays;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", mode=" + mode + ", fee=" + fee
				+ ", durationInDays=" + durationInDays + "]";
	}
	
	
	
	
}
