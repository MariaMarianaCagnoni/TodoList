package com.example.ToDo.list.service;

import com.example.ToDo.list.domain.Task;
import com.example.ToDo.list.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author mariana
 * @Project: To-Do-list
 */
@Service
public class TaskService {


    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task entity) {
        return taskRepository.save(entity);
    }

    public List<Task> findAllTasks() {
        return this.taskRepository.findAll();
    }

    public Task findTaskById(Long id) {
        return this.taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ID da tarefa não encontrado"));
    }

    public void deleteTaskById(Long id) {
        this.taskRepository.deleteById(id);
    }


    public Task updateTask(Long id, String newDescription, boolean newCompleted) {
        Task taskToUpdate = findTaskById(id);
        taskToUpdate.setDescription(newDescription);
        taskToUpdate.setCompleted(newCompleted);
        return taskRepository.save(taskToUpdate);
    }


}
