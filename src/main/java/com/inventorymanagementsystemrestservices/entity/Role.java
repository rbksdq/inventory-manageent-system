package com.inventorymanagementsystemrestservices.entity;



import com.fasterxml.jackson.annotation.JsonView;
//import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

//@ApiModel(description = "this model is to create a roles") //swagger
@Data
@Entity
@Table (name="Role")


public class Role implements Serializable {

        private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Size(min = 2, max = 50)
    @Column(name = "Role_Name", length = 50, nullable = false, unique = true)
    //@JsonView(Views.External.class)
    private String roleName;

    @OneToMany(mappedBy = "role")
    //@JsonView(Views.Internal.class)
    private List<User> user;

//    @ManyToOne(fetch = FetchType.LAZY) //foreign key
//   // @JsonIgnore
//    private User user;

//    @OneToMany(mappedBy="role")
//    private List<UserRole> userRoles;

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    //    public Role(int roleId, String roleName, List<User> user) {
//        this.roleId = roleId;
//        this.roleName = roleName;
//        this.user = user;
//    }

    //    public Role(int roleId, String roleName, User user) {
//        this.roleId = roleId;
//        this.roleName = roleName;
//        this.user = user;
//    }

    //    public Role(int roleId, String roleName, List<UserRole> userRoles) {
//        this.roleId = roleId;
//        this.roleName = roleName;
//        this.userRoles = userRoles;
//    }

//    public int getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//
//    public List<User> getUser() {
//        return user;
//    }
//
//    public void setUser(List<User> user) {
//        this.user = user;
//    }

    //    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//    }

//    public List<UserRole> getUserRoles() {
//        return userRoles;
//    }
//
//    public void setUserRoles(List<UserRole> userRoles) {
//        this.userRoles = userRoles;
//    }
}


//        @Temporal(TemporalType.TIMESTAMP)
//        private Date createdDateTime;
