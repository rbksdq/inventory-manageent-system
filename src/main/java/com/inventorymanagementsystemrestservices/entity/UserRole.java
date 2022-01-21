//package com.inventorymanagementsystemrestservices.entity;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//
//
//@Entity
//@Table(name="user_role")
//
//public class UserRole implements Serializable{
//
//        private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private int userRoleId;
//
//    //bi-directional many-to-one association to Role
//    @ManyToOne
//    private Role role;
//
//    //bi-directional many-to-one association to User
//    @ManyToOne
//    private User user;
//
//    public UserRole() {
//    }
//
//    public UserRole(int userRoleId, Role role, User user) {
//        this.userRoleId = userRoleId;
//        this.role = role;
//        this.user = user;
//    }
//
//    public int getUserRoleId() {
//        return userRoleId;
//    }
//
//    public void setUserRoleId(int userRoleId) {
//        this.userRoleId = userRoleId;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
//
