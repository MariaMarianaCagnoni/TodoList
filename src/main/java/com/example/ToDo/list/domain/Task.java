package com.example.ToDo.list.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author mariana
 * @Project: To-Do-list
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10000, nullable = false)
    private String description;

    @Column(name = "DATE_AND_TIME")
    private LocalDateTime dateAndTime;

    @Column(nullable = false)
    private boolean completed;


}
