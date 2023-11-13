package com.example.ToDo.list.service;

import com.example.ToDo.list.repository.TaskRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * @author mariana
 * @Project: To-Do-list
 */

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

}

