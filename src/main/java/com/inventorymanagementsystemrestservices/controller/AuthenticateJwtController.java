package com.inventorymanagementsystemrestservices.controller;


import com.inventorymanagementsystemrestservices.entity.User;
import com.inventorymanagementsystemrestservices.jwtUtil.JwtUtil;
import com.inventorymanagementsystemrestservices.entity.AuthenticateRequest;
import com.inventorymanagementsystemrestservices.entity.AuthenticateResponse;
import com.inventorymanagementsystemrestservices.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateJwtController {

@Autowired
    private MyUserDetailsService userDetailsService;
@Autowired
    private JwtUtil jwtTokenUtil;
@Autowired
    private AuthenticationManager authenticationManager;
//@Autowired
//private User user;

//@Autowired
//    private AuthenticateRequest authenticateRequest;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authenticateRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                   // new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));// using user insted of authenticateRequest
                   new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                //.loadUserByUsername(user.getUserName());
                .loadUserByUsername(authenticateRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }
}
