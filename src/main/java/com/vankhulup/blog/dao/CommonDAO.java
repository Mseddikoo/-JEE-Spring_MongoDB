package com.vankhulup.blog.dao;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Vans on 23.08.2014.
 */
public interface CommonDAO<Type> {
    public void save(Type entity);
    public Type getById(BigInteger id);
    public Type getByName(String name);
    public List<Type> getAll();
    public void remove(String id);
}
