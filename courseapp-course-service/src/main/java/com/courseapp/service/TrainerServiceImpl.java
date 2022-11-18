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
import com.courseapp.exception.TrainerNotFoundException;
import com.courseapp.model.Student;
import com.courseapp.model.Trainer;
import com.courseapp.repository.ITrainerRepository;

/**
 * @author JagannathSutar
 *	Trainer service class
 */
@Service
public class TrainerServiceImpl implements ITrainerService {
	
	private Logger logger = LoggerFactory.getLogger(TrainerServiceImpl.class);

	@Autowired
	private ITrainerRepository trainerRepository;

	/**
	 * This method use for add new Trainer
	 */
	@Override
	public void addTrainer(Trainer trainer) {
		trainerRepository.save(trainer);
	}

	/**
	 * This method use to update an existing Trainer
	 */
	@Override
	public void updateTrainer(Trainer trainer) {
		trainerRepository.save(trainer);
	}

	/**
	 *	This method use to delete a Trainer by trainer id
	 */
	@Override
	public void deleteTrainer(int trainerId) {
		Trainer trainer=trainerRepository.findById(trainerId).get();
		if(trainer==null) {
			logger.info("No Trainer found for Id-"+trainerId);
			throw new IdNotFoundException();
		}
		trainerRepository.deleteById(trainerId);
	}

	/**
	 *	This method use to get all Trainers
	 */
	@Override
	public List<Trainer> getAllTrainer() throws TrainerNotFoundException {
		List<Trainer> trainers = trainerRepository.findAll();
		if (trainers.isEmpty())
			throw new TrainerNotFoundException("No trainer found");
		return trainers;
	}

	/**
	 *	This method use to get a trainer by trainer id
	 */
	@Override
	public Trainer getById(int trainerId) throws IdNotFoundException {
		Trainer trainer = trainerRepository.findById(trainerId).get();
		if (trainer == null)
			throw new IdNotFoundException("Trainer Id not found");
		else
			return trainer;
	}

}
