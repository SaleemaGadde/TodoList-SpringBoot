package com.todo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.Task;
import com.todo.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    // Save Task
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
 // Get All Tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
 // Get Task By Id
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
 // Update Task
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    // Delete Task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}