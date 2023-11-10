package com.example.ToDo.list.mapper;

import com.example.ToDo.list.domain.Task;
import com.example.ToDo.list.dto.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author mariana
 * @Project: To-Do-list
 */

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO taskToTaskDTO(Task task);

    Task taskDTOToTask(TaskDTO taskDTO);

}
