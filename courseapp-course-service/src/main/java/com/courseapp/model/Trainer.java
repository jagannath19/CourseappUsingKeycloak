/**
 * 
 */
package com.courseapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author JagannathSutar
 *	Model class of Trainer
 */

@Entity
public class Trainer {
	@Id
	@GeneratedValue(generator = "speciality_gen")
	@SequenceGenerator(name="speciality_gen",sequenceName = "speciality_seq",initialValue = 10,allocationSize = 10)
	private Integer trainerId;

	private String trainerName;

	private double salary;

//	@OneToMany(mappedBy ="trainer" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private Set<Course> course;

	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Trainer(String trainerName, double salary) {
		super();
		this.trainerName = trainerName;
		this.salary = salary;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", salary=" + salary + "]";
	}

}
