package com.example.userservice.service.impl;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.User;
import com.example.userservice.repo.UserRepo;
import com.example.userservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return modelMapper.map(userRepo.save(modelMapper.map(userDTO, User.class)), UserDTO.class);
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public UserDTO getSelectedUser(String userId) {
        return modelMapper.map(userRepo.findById(userId), UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return modelMapper.map(userRepo.findAll(), List.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return modelMapper.map(userRepo.save(modelMapper.map(userDTO, User.class)), UserDTO.class);
    }
}
