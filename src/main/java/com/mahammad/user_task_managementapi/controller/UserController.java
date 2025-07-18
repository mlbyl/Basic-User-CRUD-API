package com.mahammad.user_task_managementapi.controller;

import com.mahammad.user_task_managementapi.dto.request.UserCreateRequest;
import com.mahammad.user_task_managementapi.dto.request.UserUpdateRequest;
import com.mahammad.user_task_managementapi.dto.response.UserResponse;
import com.mahammad.user_task_managementapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findallusers")
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/finduserbyid/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/saveuser")
    public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody UserCreateRequest user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest user) {
        return ResponseEntity.ok(userService.updateUser(id,user));
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
