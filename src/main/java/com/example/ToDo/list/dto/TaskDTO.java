package com.example.ToDo.list.dto;

import java.time.LocalDateTime;

/**
 * @author mariana
 * @Project: To-Do-list
 */
public record TaskDTO(Long id, String description, LocalDateTime dateAndTime, boolean completed) {
}
