package com.wainhouse.tmra.service.implementation;

import com.wainhouse.tmra.domain.Task;

import java.util.Collection;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wainhouse.tmra.repo.TaskRepo;
import com.wainhouse.tmra.service.TaskService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j // allows use to see in the console exactly what is happening.

public class taskServiceImplementation implements TaskService {
	private final TaskRepo taskRepo;

	@Override
	public Task create(Task task) {
		log.info("Saving new Task: {}", task.getTaskName()); // create task and save
		// task.setImageURL(setTaskImage()); //set a small image for the task (small file image)
		return taskRepo.save(task); // return the task which is saved
	}

	@Override
	public Collection<Task> list(int limit) {
		log.info("Fetching tasks");
		return taskRepo.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public Task get(Long id) {
		log.info("Fetching task by ID: {}", id); // create task and save
		return taskRepo.findById(id).get();
	}

	@Override
	public Task update(Task task) {
		log.info("Updating task: {}", task.getTaskName()); // create task and save
		return taskRepo.save(task); // return the task which is saved
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Deleting task: {}", id); // create task and save
		taskRepo.deleteById(id);
		return Boolean.TRUE; // return the task which is saved
	}

	private String setTaskImage() {
		String[] taskImage = { "task1.png, task2.png"};
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/Task-Management-Rest-API/Images/" + taskImage[new Random().nextInt(3)]).toUriString();
	}

}
