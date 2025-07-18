package com.mahammad.user_task_managementapi.mapper;


import com.mahammad.user_task_managementapi.dto.request.UserCreateRequest;
import com.mahammad.user_task_managementapi.dto.request.UserUpdateRequest;
import com.mahammad.user_task_managementapi.dto.response.UserResponse;
import com.mahammad.user_task_managementapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
        User toUser(UserCreateRequest request);
        User toUser(UserUpdateRequest request);
        UserResponse toUserResponse(User user);
        List<UserResponse> toUserResponse(List<User> users);
        void updateUserFromRequest(UserUpdateRequest request, @MappingTarget User user);
}
