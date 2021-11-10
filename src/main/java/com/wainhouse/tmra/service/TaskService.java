package com.wainhouse.tmra.service;

import java.util.Collection;

import com.wainhouse.tmra.domain.Task;

public interface TaskService { // added functionalities/ features
	Task create(Task task);

	Collection<Task> list(int limit); // limit amount we can see

	Task get(Long id); // get

	Task update(Task task); // update

	Boolean delete(Long id); // delete
}
