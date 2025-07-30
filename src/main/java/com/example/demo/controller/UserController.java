package com.example.demo.controller;

import com.example.demo.dto.user.CreateUserDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    // Obtener todos los usuarios

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers () {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Post
    @PostMapping
    public ResponseEntity<UserDTO> createUser (@Valid @RequestBody CreateUserDTO dto) {
      UserDTO createdUser = userService.createUser(dto);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody CreateUserDTO dto){
     UserDTO updatedUser = userService.updateUser(id, dto);
     return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteUserById (@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
