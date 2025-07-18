package com.mahammad.user_task_managementapi.service;

import com.mahammad.user_task_managementapi.dto.request.UserCreateRequest;
import com.mahammad.user_task_managementapi.dto.request.UserUpdateRequest;
import com.mahammad.user_task_managementapi.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse saveUser(UserCreateRequest request);

    UserResponse updateUser(Long id, UserUpdateRequest request);

    void deleteUser(Long id);

    UserResponse getUserById(Long id);
}
