package com.example.ToDo.list.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author mariana
 * @Project: To-Do-list
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10000,nullable = false)
    private String description;

    @Column
    private LocalDateTime dateAndTime;

    @Column(nullable = false)
    private boolean completed;

}
