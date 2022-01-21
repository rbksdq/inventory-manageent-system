//package com.inventorymanagementsystemrestservices.service;
//
//import com.inventorymanagementsystemrestservices.entity.User;
//import com.inventorymanagementsystemrestservices.exception.UserExistException;
//import com.inventorymanagementsystemrestservices.exception.UserNotFoundException;
//import com.inventorymanagementsystemrestservices.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepo userRepo;
//
//
//    public List<User> getALLUsers(){
//
//        return userRepo.findAll();
//    }
//
//    public User createUser(User user)throws UserExistException {
//        //check if user exists using username else throw UserExistException
//        User existingUser= userRepo.findByUserName(user.getUserName());
//        if(existingUser != null){
//            throw new UserExistException("user already exists in repository");
//        }
//        return userRepo.save(user);
//    }
//
//    public Optional<User> getUserById(int id)throws UserNotFoundException {
//        Optional<User> user= userRepo.findById(id);
//        if (!user.isPresent()){
//            throw new UserNotFoundException("User not found in User Repository");
//        }
//        return  user;
//    }
//
//    //user updateUserById
//    public User updateUserById(int id, User user)throws UserNotFoundException {
//        Optional<User> optionalUser= userRepo.findById( id);
//        if (!optionalUser.isPresent()){
//            throw new UserNotFoundException("User not found in User Repository, provide correct id");
//        }
//        user.setId(id);
//        return  userRepo.save(user);
//    }
//
//    //deleteUserById
//    public void deleteUserById(int id)throws UserNotFoundException{
//        Optional<User> optionalUser= userRepo.findById(id);
//        if(!optionalUser.isPresent()){
//            throw new UserNotFoundException("User not found in User Repository, provide correct id");
//        }else
//            userRepo.deleteById(id);
//
//    }
//
//    //getUserByUserName method
//    public  User getUserByUsername(String username){
//
//        return userRepo.findByUserName(username);
//    }
//
//}
