package com.user.management.repositories;


import com.user.management.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

// JpaRepository expects 2 parameters, first is the entity class and second is the type of primary key
@Component
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
