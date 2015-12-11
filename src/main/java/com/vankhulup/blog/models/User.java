package com.vankhulup.blog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * Created by Vans on 21.08.2014.
 */
@Document(collection = User.COLLECTION_NAME)
public class User {
    public static final String COLLECTION_NAME = "user";
    @Id
    private BigInteger id;
    private String userName;
    private String password;
    @Indexed(unique = true)
    private String email;
    private ROLES role;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ROLES getRole() {
        return role;
    }

    public void setRole(ROLES role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [id=" + id +", name=" + userName + ", email=" + email + ", role= "+ role + "]";
    }

    public enum ROLES {
        ROLE_USER,
        ROLE_ADMIN
    }
}
