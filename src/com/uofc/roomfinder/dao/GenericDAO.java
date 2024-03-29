package com.uofc.roomfinder.dao;

/**
 *
 * @author lauteb
 */
import java.io.Serializable;


public interface GenericDAO<T, ID extends Serializable> {

    public boolean save(T entity);

    public boolean delete(T entity);

    //public List<T> findMany(Query query);

    //public T findOne(Query query);

//    public List findAll(Class clazz);
//
//    public T findByID(Class clazz, BigDecimal id);
}
