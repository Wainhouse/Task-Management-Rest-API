package com.wainhouse.tmra.service;

import java.util.Collection;

import com.wainhouse.tmra.domain.Task;

public interface TaskService {
	Task create(Task task);

	Collection<Task> list(int limit);

	Task get(Long id);

	Task update(Task task);

	Boolean delete(String taskName);
}
