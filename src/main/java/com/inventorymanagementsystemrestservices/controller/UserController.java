package com.inventorymanagementsystemrestservices.controller;


import com.inventorymanagementsystemrestservices.entity.Role;
import com.inventorymanagementsystemrestservices.entity.User;
import com.inventorymanagementsystemrestservices.exception.RoleNameNotFoundException;
import com.inventorymanagementsystemrestservices.exception.UserNameNotFoundException;
import com.inventorymanagementsystemrestservices.repository.RoleRepo;
import com.inventorymanagementsystemrestservices.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/roles")
public class UserController {

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;


    @GetMapping("/{roleid}/users")
    public List<User> getAllUsers(@PathVariable int roleid) throws RoleNameNotFoundException {
        Optional<Role> roleOptional= roleRepo.findById(roleid);
        if (!roleOptional.isPresent())
            throw new RoleNameNotFoundException("role doesnt exist");
        return roleOptional.get().getUser();
    }


    @PostMapping("/{roleid}/users")
    public User createUser(@PathVariable int roleid, @RequestBody User user) throws RoleNameNotFoundException {
        Optional<Role> roleOptional = roleRepo.findById(roleid);
        if (!roleOptional.isPresent())
            throw new RoleNameNotFoundException("Role not found");
        Role role = roleOptional.get();
        user.setRole(role) ;
        //user.setRole(role);
        return userRepo.save(user);
    }

    //
    @GetMapping("/{roleid}/users/{userid}")
    public List<User> getUserByUserId(@PathVariable int roleid) throws RoleNameNotFoundException {
        Optional<Role> roleOptional = roleRepo.findById(roleid);
        if (!roleOptional.isPresent())
            throw new RoleNameNotFoundException("role not found");
        return roleOptional.get().getUser();
    }


    @PutMapping("/{roleid}/users/{userid}")
    public  User updateUserById(@PathVariable Long id, User user) throws UserNameNotFoundException {
        Optional<User> userOptional = userRepo.findById(id);
        if(!userOptional.isPresent())
            throw new UserNameNotFoundException("user not exist");
        user.setId(id);
        //return userRepo.saveAll(Iterable<User>);
        return userRepo.save(user);
    }

    @DeleteMapping("/{roleid}/users/{userid}")
    public void deleteUserById(@PathVariable int id,@RequestBody User user) throws UserNameNotFoundException {
        Optional<User> userOptional=userRepo.findById((long) id);
        if(!userOptional.isPresent()) {
            throw new UserNameNotFoundException("doesnt exist");
        }
        userRepo.delete(user);
    }
}

//update delete not working (error 500)

//    //getALLUsers method
//        @GetMapping
//       public List<User> getALLUsers(){
//
//        return userService.getALLUsers();
//    }
//
//
//    create user method
//    @RequestBody annotation
//    @PostMapping annotation

//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder builder) {
//        try{
//            userService.createUser(user);
//            HttpHeaders headers= new HttpHeaders();
//            headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
//            return new ResponseEntity<User>(headers, HttpStatus.CREATED);
//        }catch (UserExistException ex){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
//        }
//    }
//
//
//    //not working on postman for now
//    //getUserById
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable("id")  int id) {
//        try {
//            Optional<User> userOptional= userService.getUserById(id);
//            return userOptional.get();
//        } catch (UserNotFoundException ex){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
//        }
//    }
//
//
//
//    //updateUserById
//    @PutMapping("/{id}")
//    public User updateUserById(@PathVariable("id") int id, @RequestBody User user){
//        try{
//            return userService.updateUserById(id, user);
//        } catch (UserNotFoundException ex){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
//        }
//    }
//
//
//    //this isnt working on postman for now
//    //deleteUserById
//    @DeleteMapping("/{id}")
//    public void  deleteUserById (@PathVariable("id") int id){
//        try {
//            userService.deleteUserById(id);
//        }catch (UserNotFoundException ex){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
//        }
//    }
//
//
//
//    //getuserbyusername with throws exc
//    @GetMapping("/byusername/{username}")
//    public User getUserByUsername(@PathVariable("username") String username) throws UserNameNotFoundException {
//        User user = userService.getUserByUsername(username);
//        if(user==null)
//            throw new UserNameNotFoundException("UserName: '"+ username+"' not found in user repository");
//        return user;
//    }
//
//}

//works perfectly