package com.wainhouse.tmra.controller;


import com.wainhouse.tmra.domain.Response;
import com.wainhouse.tmra.domain.Task;
import com.wainhouse.tmra.service.implementation.taskServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static javax.security.auth.callback.ConfirmationCallback.OK;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class taskController {

    private final taskServiceImplementation taskService; //bring in the service implementation

    @GetMapping("/list") // created list of task
    public ResponseEntity<Response> getTasks() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("tasks", taskService.list(30))) //amount of tasks to return
                        .message("Tasks updated")
                        .statusCode(OK)
                        .build()
        );

    }

    @PostMapping("/save") // created list of task
    public ResponseEntity<Response> saveTask(@RequestBody @Valid Task task) { //checks Task for validation
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("tasks", taskService.create(task))) //amount of tasks to return
                        .message("Tasks created")
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}") // created list of task
    public ResponseEntity<Response> getTasks(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("task", taskService.get(id))) //amount of tasks to return
                        .message("Task retrieved")
                        .statusCode(OK)
                        .build()
        );

    }

    @DeleteMapping("/delete/{id}") // created list of task
    public ResponseEntity<Response> deleteTasks(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", taskService.delete(id))) //amount of tasks to return
                        .message("deleted")
                        .statusCode(OK)
                        .build()
        );

    }

    @GetMapping(path = "/Images/{filename}", produces = IMAGE_PNG_VALUE)
    public byte[] getTaskImage(@PathVariable("filename") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "Downloads/images" + fileName));


    }
}
