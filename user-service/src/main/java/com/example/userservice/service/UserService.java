package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    void deleteUser(String userId);
    UserDTO getSelectedUser(String userId);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO);
}
