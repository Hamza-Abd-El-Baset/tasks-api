package com.hamza.tasks_api.controller;

import com.hamza.tasks_api.entity.Task;
import com.hamza.tasks_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> getAllTasks(@RequestBody Task taskDetails) {
        Task task = taskService.createTask(taskDetails);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }


    @PutMapping ("/{id}")
    public ResponseEntity<?> updateTaskById(@PathVariable("id") Long id, @RequestBody Task taskDetails) {
        Task task = taskService.updateTask(id, taskDetails);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }


}
