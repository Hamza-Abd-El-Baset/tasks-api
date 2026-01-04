package com.hamza.tasks_api.service;

import com.hamza.tasks_api.entity.Task;
import com.hamza.tasks_api.entity.User;
import com.hamza.tasks_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private User getAuthenticatedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public List<Task> getAllTasks() {
        User user = getAuthenticatedUser();
        return taskRepository.findByUserId(user.getId());
    }

    public Task createTask(Task task) {
        task.setUser(getAuthenticatedUser());
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        User user = getAuthenticatedUser();

        Task task = taskRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Task not found or access denied"));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());

        return taskRepository.save(task);
    }

    public void deleteTaskById(Long id) {
        User user = getAuthenticatedUser();

        Task task = taskRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Task not found or access denied"));

        taskRepository.delete(task);
    }
}
