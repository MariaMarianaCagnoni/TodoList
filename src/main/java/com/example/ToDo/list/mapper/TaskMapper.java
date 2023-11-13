package com.example.ToDo.list.mapper;

import com.example.ToDo.list.domain.Task;
import com.example.ToDo.list.dto.TaskDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    Task toEntity(TaskDTO taskDTO);

    TaskDTO toDto(Task task);

    List<TaskDTO> toDto(List<Task> allTasks);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task partialUpdate(TaskDTO taskDTO, @MappingTarget Task task);
}
