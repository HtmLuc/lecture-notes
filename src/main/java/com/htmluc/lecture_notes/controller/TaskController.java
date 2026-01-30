package com.htmluc.lecture_notes.controller;

import com.htmluc.lecture_notes.model.TaskModel;
import com.htmluc.lecture_notes.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public ResponseEntity<TaskModel> create(@RequestBody TaskModel taskModel) {
        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.ok(task);
    }
}
