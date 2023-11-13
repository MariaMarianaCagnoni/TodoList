package com.example.ToDo.list.service;

import com.example.ToDo.list.domain.Task;
import com.example.ToDo.list.repository.TaskRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Task createTask(Task newTask) {
        if (newTask.getId() != null && taskRepository.existsById(newTask.getId())) {
            throw new IllegalArgumentException("Já existe uma task com esse ID.");
        }
        return taskRepository.save(newTask);
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


    @Transactional
    public Task updateTask(Long id, String newDescription, boolean newCompleted) {
        Task taskToUpdate = findTaskById(id);
        taskToUpdate.setDescription(newDescription);
        taskToUpdate.setCompleted(newCompleted);
        return taskRepository.save(taskToUpdate);
    }


}
