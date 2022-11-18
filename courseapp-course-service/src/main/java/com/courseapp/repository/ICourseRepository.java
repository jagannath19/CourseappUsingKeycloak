package com.courseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courseapp.model.Course;
/**
 * 	@author JagannathSutar
 *	Course repository for database operation
 *	Extends from JpaRepository
 */
@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
