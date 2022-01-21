package com.inventorymanagementsystemrestservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "Users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonView(Views.External.class)
    private Long id;

    //@JsonView(Views.External.class)
    private String userName;

    //@JsonView(Views.External.class)
    private String email;

    //@JsonView(Views.External.class)
    private String password;

    //@JsonView(Views.External.class)
    private BigDecimal contactNumber;

    @ManyToOne
    @JsonIgnore
    //@JsonView(Views.Internal.class)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(BigDecimal contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
