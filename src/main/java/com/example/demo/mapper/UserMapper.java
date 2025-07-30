package com.example.demo.mapper;

import com.example.demo.dto.user.CreateUserDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId().longValue());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User toEntity(CreateUserDTO dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}
