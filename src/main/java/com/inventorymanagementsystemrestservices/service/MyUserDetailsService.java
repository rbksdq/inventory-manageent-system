//package com.inventorymanagementsystemrestservices.service;
//
//import com.inventorymanagementsystemrestservices.entity.MyUserDetails;
//import com.inventorymanagementsystemrestservices.entity.User;
//import com.inventorymanagementsystemrestservices.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    UserRepo userRepo;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepo.findByUserName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("use not found in repo " + username));
//        return MyUserDetails.build(user);
//    }
//}
////        userOptional.orElseThrow(() -> new UsernameNotFoundException("not found " + username));
////        return  userOptional.map(MyUserDetails::new).get();
//// return UserDetailsService;
//
//
