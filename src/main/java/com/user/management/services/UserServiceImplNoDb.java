//package com.user.management.services;
//
//import com.user.management.entities.UserEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@Service // tell the spring that this is a service class (working on service layer)
//public class UserServiceImplNoDb implements UserService {
//
//    List<UserEntity> users;
//
//    public UserServiceImplNoDb() {
//        users = new ArrayList<>();
//        users.add(new UserEntity("1","Daksh Gupta", "Daksh", "Gupta",
//                "7827662636", "t-daksh.gupta@ocltp.com",
//                "Ghaziabad, India", "Noida, India"));
//        users.add(new UserEntity("2","Gaurav Kumar", "Gaurav", "Kumar",
//                "457343355", "gaurav.kumar2645@gmail.com",
//                "Ghaziabad, India", "Delhi, India"));
//
//    }
//
//
//    @Override
//    public List<UserEntity> getAllUsers() {
//        return users;
//    }
//
//    @Override
//    public UserEntity getSingleUser(String userId) {
//        UserEntity user = null;
//        for(UserEntity userEntity: users){
//            if(userEntity.getUserId().equals(userId)){
//                user = userEntity;
//                break;
//            }
//        }
//        return user;
//    }
//
//    @Override
//    public UserEntity addUser(UserEntity userEntity) {
//        users.add(userEntity);
//        return userEntity;
//    }
//
//    @Override
//    public UserEntity updateUser(UserEntity userEntity){
//        for(int i=0; i<users.size(); i++){
//            if(users.get(i).getUserId().equals(userEntity.getUserId())){
//                users.set(i, userEntity);
//                break;
//            }
//        }
//        return userEntity;
//    }
//
//    @Override
//    public UserEntity deleteSingleUser(String userId){
//        UserEntity user = null;
//        for(UserEntity userEntity: users){
//            if(userEntity.getUserId().equals(userId)){
//                user = userEntity;
//                users.remove(userEntity);
//                break;
//            }
//        }
//        return user;
//    }
//}
