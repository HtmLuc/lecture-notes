package com.htmluc.lecture_notes.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.htmluc.lecture_notes.model.UserModel;
import com.htmluc.lecture_notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if (user != null) {
            return ResponseEntity.badRequest().build();
        }

        var passwordHashered = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashered);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.ok(userCreated);
    }
}
