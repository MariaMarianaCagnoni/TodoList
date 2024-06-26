package com.example.ToDo.list.exception;

public class TaskNotFoundException extends  RuntimeException{

    public TaskNotFoundException(String message) {
        super(message);
    }


}
