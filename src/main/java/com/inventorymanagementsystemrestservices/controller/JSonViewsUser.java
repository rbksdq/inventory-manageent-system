//package com.inventorymanagementsystemrestservices.controller;
//
//
//import com.fasterxml.jackson.annotation.JsonView;
//import com.inventorymanagementsystemrestservices.entity.User;
//import com.inventorymanagementsystemrestservices.exception.UserNotFoundException;
//import com.inventorymanagementsystemrestservices.repository.UserRepo;
//import com.inventorymanagementsystemrestservices.views.Views;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//import javax.validation.constraints.Min;
//import java.util.Optional;
//
//@RestController
//@Validated
//@RequestMapping(value = "/jsonviews/users")
//public class JSonViewsUser {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @JsonView(Views.External.class)
//    @GetMapping("/external/{id}")
//    public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id){
//        return userRepo.findById(id);
//    }
//
//    //getUserById internal vies
//    @JsonView(Views.Internal.class)
//    @GetMapping("/internal/{id}")
//    public User getUserById2(@PathVariable("id") @Min(1) Long id){
//        return userRepo.getById(id);
//    }
//
//}
