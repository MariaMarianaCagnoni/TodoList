package com.example.ToDo.list.repository;

import com.example.ToDo.list.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mariana
 * @Project: To-Do-list
 */

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
