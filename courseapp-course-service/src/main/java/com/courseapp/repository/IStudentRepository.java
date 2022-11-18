package com.courseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courseapp.model.Student;
/**
 * @author JagannathSutar
 *	Student repository for database operation
 *	Extends from JpaRepository
 */
@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
