package com.user.management.services;

import com.user.management.ApiResponse;
import com.user.management.entities.UserEntity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface UserService {
//    public List<UserEntity> getAllUsers();
//    public UserEntity getSingleUser(String userId);
//    public UserEntity addUser(UserEntity userEntity);
//    public UserEntity updateUser(UserEntity userEntity);
//    public UserEntity deleteSingleUser(String userId);

    ApiResponse<List<UserEntity>> getAllUsers();
    ApiResponse<UserEntity> getSingleUser(String userId);
    ApiResponse<UserEntity> addUser(UserEntity userEntity);
    ApiResponse<UserEntity> updateUser(UserEntity userEntity);
    ApiResponse<UserEntity> deleteSingleUser(String userId);
}
