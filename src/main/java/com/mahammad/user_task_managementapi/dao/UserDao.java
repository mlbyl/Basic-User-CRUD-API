package com.mahammad.user_task_managementapi.dao;

import com.mahammad.user_task_managementapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
