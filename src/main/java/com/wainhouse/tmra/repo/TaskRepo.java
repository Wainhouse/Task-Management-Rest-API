package com.wainhouse.tmra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wainhouse.tmra.domain.Task;

public interface TaskRepo extends JpaRepository<Task, Long> { /// extend JPA, this gives use access to a load of methods

	Task findbytaskName(String taskName); // find our tasks by their name
}
