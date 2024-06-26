package com.example.ToDo.list.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author mariana
 * @Project: To-Do-list
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 10000, nullable = false)
    private String description;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;


}
