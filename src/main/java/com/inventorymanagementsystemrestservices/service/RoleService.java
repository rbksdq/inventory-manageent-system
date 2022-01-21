package com.inventorymanagementsystemrestservices.service;


import com.inventorymanagementsystemrestservices.entity.Role;
import com.inventorymanagementsystemrestservices.exception.RoleExistException;
import com.inventorymanagementsystemrestservices.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    public RoleRepo roleRepo;

    public List<Role> getAllRoles(){
        return roleRepo.findAll();
    }

    public Role createRole(Role role) throws RoleExistException {
        Role existingRole= roleRepo.findByRoleName(role.getRoleName());
        if (existingRole!=null){
            throw new RoleExistException("Role already exist in repo");
        }
        return roleRepo.save(role);
    }

    public Optional<Role> getRoleById(int roleid)throws RoleNotFoundException {
        Optional<Role> role= roleRepo.findById(roleid);
        if (!role.isPresent()){
            throw new RoleNotFoundException("role not found in role Repository");
        }
        return  role;
    }


    public Role updateRoleById(int roleId, Role role)throws RoleNotFoundException {
        Optional<Role> optionalRole= roleRepo.findById( roleId);
        if (!optionalRole.isPresent()){
            throw new RoleNotFoundException("Role not found in Role Repository, provide correct id");
        }
        role.setRoleId(roleId);
        return  roleRepo.save(role);
    }


    public void deleteRoleById(int id)throws RoleNotFoundException{
        Optional<Role> optionalRole= roleRepo.findById(id);
        if(!optionalRole.isPresent()){
            throw new RoleNotFoundException("Role not found in role Repository, provide correct id");
        }else
            roleRepo.deleteById(id);
    }


    public  Role getRoleByRolename(String roleName){
        return roleRepo.findByRoleName(roleName);
    }
}