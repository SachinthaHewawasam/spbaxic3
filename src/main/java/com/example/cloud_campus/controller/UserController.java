package com.example.cloud_campus.controller;


import com.example.cloud_campus.exception.ResourceNotFoundException;
import com.example.cloud_campus.model.User;
import com.example.cloud_campus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Get All Notes
    @GetMapping("/users")
    public List<User> getAllNotes() {
        return userRepository.findAll();
    }

    // Create a new User
    @PostMapping("/users")
    public User createNote(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    // Get a Single User
    @GetMapping("/users/{id}")
    public User getNoteById(@PathVariable(value = "id") Long Id) {
        return userRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
    }


    @PutMapping("/users/{id}")
    public User updateNote(@PathVariable(value = "id") Long Id,
                           @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));

        user.setId(userDetails.getId());
//      user.setTitle(userDetails.getTitle());
        user.setUser_type(userDetails.getUser_type());
//      user.setContent(userDetails.getContent());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    // Delete a User
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}