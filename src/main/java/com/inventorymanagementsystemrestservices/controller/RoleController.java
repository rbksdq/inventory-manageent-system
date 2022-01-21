package com.inventorymanagementsystemrestservices.controller;


import com.inventorymanagementsystemrestservices.entity.Role;
import com.inventorymanagementsystemrestservices.exception.*;
import com.inventorymanagementsystemrestservices.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "roles")
public class RoleController {

    @Autowired
    public RoleService roleService;


    @GetMapping
    public List<Role> getAllRoles() {

        return roleService.getAllRoles();
    }


    //create user method
    //@RequestBody annotation
    //@PostMapping annotation



    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role, UriComponentsBuilder builder) {
        try {
            roleService.createRole(role);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/roles/{roleid}").buildAndExpand(role.getRoleId()).toUri());
            return new ResponseEntity<Role>(headers, HttpStatus.CREATED);
        } catch (RoleExistException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }


    @GetMapping("/{roleid}")
    public Role getRoleById(@PathVariable("roleid") int roleid) {
        try {
            Optional<Role> roleOptional = roleService.getRoleById(roleid);
            return roleOptional.get();
        } catch (RoleNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }


    //not working
    @PutMapping("/{roleid}")
    public Role updateRoleById(@PathVariable("roleid") int roleId, @RequestBody Role role) {
        try {
            return roleService.updateRoleById(roleId, role);
        } catch (RoleNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }


    @DeleteMapping("/{roleid}")
    public void deleteRoleById(@PathVariable("roleid") int roleId) {
        try {
            roleService.deleteRoleById(roleId);
        } catch (RoleNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }


    @GetMapping("/byrolename/{rolename}")
    public Role getRoleByRolename(@PathVariable("rolename") String rolename) throws RoleNameNotFoundException {
        Role role = roleService.getRoleByRolename(rolename);
        if (role == null)
            throw new RoleNameNotFoundException("RoleName: '" + rolename + "' not found in role repository");
        return role;
    }
}

//works perfectly






//    @GetMapping("/{userid}/roles")//doesnt retrieve saved value
//    public List<Role> getAllRoles(@PathVariable int userid) throws UserNameNotFoundException{
//        Optional<User> userOptional= userRepo.findById(userid);
//        if (!userOptional.isPresent())
//            throw new UserNameNotFoundException("user doesnt exist");
//        return userOptional.get().getRole();
//    }
//
//
//    @PostMapping("/{userid}/roles")//working
//    public Role createRole(@PathVariable int userid, @RequestBody Role role) throws UserNameNotFoundException {
//        Optional<User> userOptional = userRepo.findById(userid);
//        if (!userOptional.isPresent())
//            throw new UserNameNotFoundException("User not found");
//        User user = userOptional.get();
//        role.setUser(user);
//        return roleRepo.save(role);
//    }
//
//    @GetMapping("/{userid}/roles/{roleid}")//null list
//    public List<Role> getRolesByRoleId(@PathVariable int userid) throws UserNameNotFoundException {
//        Optional<User> userOptional = userRepo.findById(userid);
//        if (!userOptional.isPresent())
//            throw new UserNameNotFoundException("user not found");
//        return userOptional.get().getRole();
//    }
//
//    //update role
//    @PutMapping("/{userid}/roles/{roleid}")//null list
//    public  Role updateRoleById(@PathVariable int userid, Role role) throws UserNameNotFoundException {
//        Optional<User> userOptional = userRepo.findById(userid);
//        if(!userOptional.isPresent())
//            throw new UserNameNotFoundException("user not exist");
//        role.setRoleId(role.getRoleId());
//        return roleRepo.save(role);
//    }
//
//    @DeleteMapping("/{userid}/roles/{roleid}")
//    public void deleteRoleById(int roleid, Role role) throws RoleNameNotFoundException {
//        Optional<Role> roleOptional=roleRepo.findById(roleid);
//        if(!roleOptional.isPresent()) {
//            throw new RoleNameNotFoundException("doesnt exist");
//        }
//        roleRepo.delete(role);
//    }
//}
