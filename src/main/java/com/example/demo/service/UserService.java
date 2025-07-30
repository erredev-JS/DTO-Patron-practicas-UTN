package com.example.demo.service;

import com.example.demo.dto.user.CreateUserDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
        .stream()
                .map(UserMapper::toDTO)
                .toList();

}

public UserDTO createUser(CreateUserDTO dto){
        User user = UserMapper.toEntity(dto);
        return UserMapper.toDTO(userRepository.save(user));
}

public UserDTO updateUser (Long id, CreateUserDTO dto){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if(dto.getName() != null){
        user.setName(dto.getName());
        }
        if(dto.getEmail() != null){
        user.setEmail(dto.getEmail());
        }

        return UserMapper.toDTO(userRepository.save(user));
}

    public void deleteUser(Long id){

        userRepository.deleteById(id);


    }


}
