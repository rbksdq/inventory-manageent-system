package com.inventorymanagementsystemrestservices.repository;


//import com.inventorymanagementsystemrestservices.entity.User;
import com.inventorymanagementsystemrestservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);

   // Optional<User> findById(int id);

//    User findByUserName(String username);
//
//    Optional<User> findById(int id);
}
