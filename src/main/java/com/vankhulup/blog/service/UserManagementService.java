package com.vankhulup.blog.service;

import com.vankhulup.blog.dao.UserDAO;
import com.vankhulup.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Vans on 23.08.2014.
 */
@Service
public class UserManagementService extends CommonService<UserDAO>{

    @Autowired
    PasswordEncoder encoder;
    public void saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(User.ROLES.ROLE_USER);
        dao.save(user);
    }

    @Override
    @Autowired
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public List<User> getAllUsers(){
        return dao.getAll();
    }

    public User getUserById(BigInteger id){
        return dao.getById(id);
    }

    public User getUserByName(String username) {
        return dao.getByName(username);
    }
}
