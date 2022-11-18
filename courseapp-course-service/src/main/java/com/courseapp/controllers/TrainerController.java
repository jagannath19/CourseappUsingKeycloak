/**
 * 
 */
package com.courseapp.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseapp.exception.IdNotFoundException;
import com.courseapp.model.Course;
import com.courseapp.model.Trainer;
import com.courseapp.service.ITrainerService;

/**
 * @author JagannathSutar
 * Controller class for Trainer
 *
 */
@RestController
@RequestMapping("course-serv")
public class TrainerController {

	@Autowired
	private ITrainerService trainerService;
	
	private Logger logger = LoggerFactory.getLogger(TrainerController.class);
	
	/**
	 * @param trainer
	 * @return http status for  add trainer
	 * Allow role for only ADMIN
	 */
	@RolesAllowed("ADMIN")
	@PostMapping("/addTrainer")
	ResponseEntity<Void> addTrainer(@RequestBody Trainer trainer) {

		logger.info("Adding one Trainer " + trainer);
		trainerService.addTrainer(trainer);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	/**
	 * @param trainer
	 * @return http status for update trainer
	 * Allow role for only ADMIN
	 */
	@RolesAllowed("ADMIN")
	@PutMapping("/updateTrainer/id/{id}/salary/{salary}")
	ResponseEntity<Void> updateCourse(@PathVariable("id")int id,@PathVariable("salary")double salary) {
		

		Trainer trainer=trainerService.getById(id);
		if(trainer==null) {
			logger.warn("No trainer found for id-"+id);
			throw new IdNotFoundException("No trainer Found ");
		}
		trainer.setSalary(salary);
		trainerService.updateTrainer(trainer);
		
		
		return ResponseEntity.ok().build();
	}
	
	/**
	 * @param trainerId
	 * Allow role for only ADMIN
	 */
	@RolesAllowed("ADMIN")
	@DeleteMapping("/deleteTrainer/{trainerId}")
	void deleteTrainer(@PathVariable("trainerId")int trainerId){
		logger.info("Trainer deleted");
		trainerService.deleteTrainer(trainerId);
		
	}
	
	
	/**
	 * @return list of all trainer 
	 * Allow role for only ADMIN
	 */
	@RolesAllowed("ADMIN")
	@GetMapping("/trainers")
	ResponseEntity<List<Trainer>> getAll(){
		logger.info("Showing all Trainers");
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "It returns all the trainers");
		List<Trainer> trainers=trainerService.getAllTrainer();
		ResponseEntity<List<Trainer>> responseEntity=new ResponseEntity<List<Trainer>>(trainers,header,HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * @param trainerId
	 * @return one trainer object
	 * Allow role for only ADMIN
	 */
	@RolesAllowed("ADMIN")
	@GetMapping("/trainer/{trainerId}")
	ResponseEntity<Trainer> getTrainerById(@PathVariable("trainerId") int trainerId) {
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "get trainer by Id");
		return ResponseEntity.ok().headers(header).body(trainerService.getById(trainerId));
	}
}
