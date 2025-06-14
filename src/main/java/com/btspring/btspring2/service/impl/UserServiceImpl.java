package com.btspring.btspring2.service.impl;

import com.btspring.btspring2.convert.UserMapper;
import com.btspring.btspring2.model.dto.request.UserRequestDTO;
import com.btspring.btspring2.model.entity.UserEntity;
import com.btspring.btspring2.repository.UserRepository;
import com.btspring.btspring2.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void addUser(UserRequestDTO userRequestDTO) {
       UserEntity userEntity = userMapper.toUserEntity(userRequestDTO);
       userRepository.save(userEntity);
       System.out.println("server || " + userEntity.getName() +  " " +
               userEntity.getGender()  + " " + userEntity.getBirthday() + " " +userEntity.getAddress());
    }

    @Override
    public void updateUser(int id, UserRequestDTO userRequestDTO) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();
        userEntity.setName(userRequestDTO.getName());
        userEntity.setGender(userRequestDTO.getGender());
        userEntity.setBirthday(userRequestDTO.getBirthday());
        userEntity.setAddress(userRequestDTO.getAddress());
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(int id) {
            UserEntity userEntity = userRepository.findById(id).orElse(null);
            userRepository.delete(userEntity);
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

}
