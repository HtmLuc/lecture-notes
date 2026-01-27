package com.htmluc.lecture_notes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_users") // Anotação define uma entidade
public class UserModel {

    @Id // Anotação que define a chame primária
    @GeneratedValue(generator = "UUID") // Anotação que gera valores
    private UUID id;

    @Column(unique = true) // Anotação que define valor como único
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
