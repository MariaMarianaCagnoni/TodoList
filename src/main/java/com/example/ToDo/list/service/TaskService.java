package com.example.ToDo.list.service;

import com.example.ToDo.list.domain.Task;
import com.example.ToDo.list.exception.TaskNotFoundException;
import com.example.ToDo.list.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author mariana
 * @Project: To-Do-list
 */
@Log4j2
@Service
public class TaskService {


    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> findAllTasks() {
        return this.taskRepository.findAll();
    }

    public Task findTaskById(Long id) {
        log.info("searching for task with id: " + id);
        return this.taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("ID da tarefa não encontrado"));
    }

    public void deleteTaskById(Long id) {
        this.taskRepository.deleteById(id);
        log.info("task deletada pelo id");
    }

    @Transactional
    public Task createTask(Task newTask) {
        if (newTask.getId() != null && taskRepository.existsById(newTask.getId())) {
            log.info("Tentativa de criar uma nova task com ID já existente");
            throw new IllegalArgumentException("Já existe uma task com esse ID.");
        }
        return taskRepository.save(newTask);
    }

    @Transactional
    public Task updateTask(Long id, String newDescription, boolean newCompleted) {
        Task taskToUpdate = findTaskById(id);
        taskToUpdate.setDescription(newDescription);
        taskToUpdate.setCompleted(newCompleted);
        return taskRepository.save(taskToUpdate);
    }


}
