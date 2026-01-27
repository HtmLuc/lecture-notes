package com.htmluc.lecture_notes.repository;

import com.htmluc.lecture_notes.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

}
