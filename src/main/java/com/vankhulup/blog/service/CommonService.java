package com.vankhulup.blog.service;

import com.vankhulup.blog.dao.CommonDAO;

/**
 * Created by Vans on 23.08.2014.
 */
public abstract class CommonService<DAOType extends CommonDAO> {

    protected DAOType dao;

    public abstract void setDao(DAOType dao);
}
