//package com.inventorymanagementsystemrestservices.entity;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class MyUserDetails implements UserDetails {
//
//    private String username;
//    private String password;
//    private  List<GrantedAuthority> authorities;//Collection<? extends GrantedAuthority> authorities;
//
//    // private List<GrantedAuthority> authorities;
//
//    public MyUserDetails(String username, String password, List<GrantedAuthority> authorities) {
//        this.username = username;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//
////
////
////    public MyUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
////        this.username = username;
////        this.password = password;
////        this.authorities = authorities;
////    }
//
//    public static MyUserDetails build(User user){
//        List<GrantedAuthority> authorities= Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getRoleName())); //user.getRole()
////                .stream()
////                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
//              //  .collect(Collectors.toList());
//
//        return new MyUserDetails(
//                user.getUserName(),
//                user.getPassword(),
//                authorities);
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true ;
//    }
//
//}
