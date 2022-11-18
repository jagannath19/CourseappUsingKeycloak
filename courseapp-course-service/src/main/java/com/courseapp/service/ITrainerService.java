package com.courseapp.service;

import java.util.List;

import com.courseapp.model.Trainer;

public interface ITrainerService {

	void addTrainer(Trainer trainer);

	void updateTrainer(Trainer trainer);

	void deleteTrainer(int trainerId);

	List<Trainer> getAllTrainer();

	Trainer getById(int trainerId);

}
