package com.courseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courseapp.model.Trainer;
/**
 * @author JagannathSutar
 *	Trainer repository for database operation
 *	Extends from JpaRepository
 */
@Repository
public interface ITrainerRepository extends JpaRepository<Trainer, Integer> {

}
