package com.user.management.services;

import com.user.management.ApiResponse;
import com.user.management.entities.UserEntity;
import com.user.management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // tell the spring that this is a service class (working on service layer)
public class UserServiceImpl implements UserService {

    @Autowired // it will create the object of Impl class of  UserRepository and inject it here
    private UserRepository userRepository;

    public UserServiceImpl() {}


    @Override
    public ApiResponse<List<UserEntity>> getAllUsers() {
        try {
            List<UserEntity> users = userRepository.findAll();
            return new ApiResponse<>(true, "Users fetched successfully", users);
        } catch (Exception e) {
            return new ApiResponse<>(false, "Error fetching all users: " + e.getMessage(), null);
        }
    }

    @Override
    public ApiResponse<UserEntity> getSingleUser(String userId) {
        try {
            UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
            return new ApiResponse<>(true, "User fetched successfully", user);
        } catch (Exception e) {
            return new ApiResponse<>(false, "Error fetching user: " + e.getMessage(), null);
        }
    }

    @Override
    public ApiResponse<UserEntity> addUser(UserEntity userEntity) {
        try {
            // Check if userId is not provided, generate a random one
            if (userEntity.getUserId() == null || userEntity.getUserId().trim().isEmpty()) {
                String randomUserId = "USER_" + System.currentTimeMillis();
                userEntity.setUserId(randomUserId);
            }
            
            // Check for existing user with same ID, email, or phone
            for(UserEntity user : userRepository.findAll()) {
                if(user.getUserId().equals(userEntity.getUserId()) || 
                   user.getEmailId().equals(userEntity.getEmailId()) || 
                   user.getMobileNumber().equals(userEntity.getMobileNumber())) {
                    return new ApiResponse<>(false, "User already exists with same ID, email, or phone number", null);
                }
            }
            UserEntity savedUser = userRepository.save(userEntity);
            return new ApiResponse<>(true, "User added successfully", savedUser);
        } catch (Exception e) {
            return new ApiResponse<>(false, "Error adding user: " + e.getMessage(), null);
        }
    }

    @Override
    public ApiResponse<UserEntity> updateUser(UserEntity userEntity) {
        try {
            if(userEntity.getUserId() == null || userEntity.getUserId().trim().isEmpty()) {
                return new ApiResponse<>(false, "User ID is required to update user", null);
            }
            if (!userRepository.existsById(userEntity.getUserId())) {
                return new ApiResponse<>(false, "User not found with id: " + userEntity.getUserId(), null);
            }
            UserEntity updatedUser = userRepository.save(userEntity);
            return new ApiResponse<>(true, "User updated successfully", updatedUser);
        } catch (Exception e) {
            return new ApiResponse<>(false, "Error updating user: " + e.getMessage(), null);
        }
    }

    @Override
    public ApiResponse<UserEntity> deleteSingleUser(String userId) {
        try {
            UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
            userRepository.deleteById(userId);
            return new ApiResponse<>(true, "User deleted successfully", user);
        } catch (Exception e) {
            return new ApiResponse<>(false, "Error deleting user: " + e.getMessage(), null);
        }
    }
}
