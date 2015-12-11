package com.vankhulup.blog.dao;

import com.vankhulup.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Vans on 23.08.2014.
 */
@Repository
public class UserDAO implements CommonDAO<User> {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void save(User entity) {
        mongoOperations.save(entity);
    }

    @Override
    public User getById(BigInteger id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), User.class);
    }
    public User getByName(String username) {
        return mongoOperations.findOne(Query.query(Criteria.where("userName").is(username)), User.class);
    }

    @Override
    public List<User> getAll() {
        return mongoOperations.findAll(User.class);
    }

    @Override
    public void remove(String id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), User.class);
    }
}
