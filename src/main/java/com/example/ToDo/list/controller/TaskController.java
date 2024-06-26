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
        TaskDTO taskDTO = taskMapper.toDto(task);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        // Usando o mapeamento do TaskMapper para converter TaskDTO para Task
        Task task = taskMapper.toEntity(taskDTO);

        // Chama o serviço para criar a tarefa
        Task newTask = taskService.createTask(task);

        // Converte a nova tarefa de volta para TaskDTO
        TaskDTO newTaskDTO = taskMapper.toDto(newTask);

        return new ResponseEntity<>(newTaskDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAllTasks() {
        List<Task> allTasks = taskService.findAllTasks();
        List<TaskDTO> allTaskDTOs = taskMapper.toDto(allTasks);
        return new ResponseEntity<>(allTaskDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(
            @PathVariable Long id,
            @RequestBody TaskDTO requestDTO) {

        Task request = taskMapper.toEntity(requestDTO);

        String newDescription = request.getDescription();
        boolean newCompleted = request.isCompleted();

        Task updatedTask = taskService.updateTask(id, newDescription, newCompleted);
        TaskDTO updatedTaskDTO = taskMapper.toDto(updatedTask);

        return new ResponseEntity<>(updatedTaskDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}


