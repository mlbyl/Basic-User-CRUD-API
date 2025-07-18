package com.mahammad.user_task_managementapi.service.impl;

import com.mahammad.user_task_managementapi.dao.UserDao;
import com.mahammad.user_task_managementapi.dto.request.UserCreateRequest;
import com.mahammad.user_task_managementapi.dto.request.UserUpdateRequest;
import com.mahammad.user_task_managementapi.dto.response.UserResponse;
import com.mahammad.user_task_managementapi.mapper.UserMapper;
import com.mahammad.user_task_managementapi.model.User;
import com.mahammad.user_task_managementapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserMapper userMapper;

    public UserServiceImpl(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userDao.findAll();
        return userMapper.toUserResponse(users);
    }

    public UserResponse saveUser(UserCreateRequest request) {
        User user = userMapper.toUser(request);
        User updatedUser = userDao.save(user);
        return userMapper.toUserResponse(updatedUser);
    }


    public UserResponse getUserById(Long id) {
        User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserResponse(user);

    }

    public UserResponse updateUser(Long id, UserUpdateRequest request) {
        User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUserFromRequest(request, user);
        User updatedUser = userDao.save(user);

        return userMapper.toUserResponse(updatedUser);
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
