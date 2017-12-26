package io.ryanliang.ryanet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImplementation<T>
        implements GenericDaoInterface<T> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){

        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public T persist(T entity) {

        this.getSession().persist(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {

        this.getSession().delete(entity);
    }
}
