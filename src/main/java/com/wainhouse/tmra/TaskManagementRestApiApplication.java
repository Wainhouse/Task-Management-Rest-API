package com.wainhouse.tmra;

import com.wainhouse.tmra.domain.Task;
import com.wainhouse.tmra.enumeration.Status;
import com.wainhouse.tmra.repo.TaskRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.wainhouse.tmra.enumeration.Status.TASK_NOT_COMPLETED;

@NoArgsConstructor
@AllArgsConstructor
@SpringBootApplication
public class TaskManagementRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementRestApiApplication.class, args);
	}

		CommandLineRunner run(TaskRepo taskRepo) {
			return args -> {
				taskRepo.save(new Task(null, "DO", "02/02", "Urgent", "http://localhost:8080/server/images/image1.png", TASK_NOT_COMPLETED));
				taskRepo.save(new Task(null, "DO That", "02/02", "Urgent", "http://localhost:8080/server/images/image1.png", TASK_NOT_COMPLETED));
				taskRepo.save(new Task(null, "DO This", "02/02", "Urgent", "http://localhost:8080/server/images/image1.png", TASK_NOT_COMPLETED));
				taskRepo.save(new Task(null, "DON'T", "02/02", "Urgent", "http://localhost:8080/server/images/image1.png", TASK_NOT_COMPLETED));
			};

		}
}
