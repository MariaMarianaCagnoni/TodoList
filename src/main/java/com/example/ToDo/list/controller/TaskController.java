package com.example.ToDo.list.controller;

import com.example.ToDo.list.domain.Task;
import com.example.ToDo.list.dto.TaskDTO;
import com.example.ToDo.list.mapper.TaskMapper;
import com.example.ToDo.list.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mariana
 * @Project: To-Do-list
 */

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
        Task task = taskService.findTaskById(id);
        TaskDTO taskDTO = taskMapper.taskToTaskDTO(task);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        Task task = taskMapper.taskDTOToTask(taskDTO);
        TaskDTO createdTaskDTO = taskMapper.taskToTaskDTO(task);
        return new ResponseEntity<>(createdTaskDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAllTasks() {
        List<Task> allTasks = taskService.findAllTasks();
        List<TaskDTO> allTasksDTO = taskMapper.tasksToTaskDTOs(allTasks);
        return new ResponseEntity<>(allTasksDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(
            @PathVariable Long id,
            @RequestParam String newDescription,
            @RequestParam boolean newCompleted) {

        Task updatedTask = taskService.updateTask(id, newDescription, newCompleted);
        TaskDTO updatedTaskDTO = taskMapper.taskToTaskDTO(updatedTask);
        return new ResponseEntity<>(updatedTaskDTO, HttpStatus.OK);
    }


}
