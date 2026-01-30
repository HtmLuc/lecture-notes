package com.htmluc.lecture_notes.repository;

import com.htmluc.lecture_notes.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskModel, UUID> {
}
