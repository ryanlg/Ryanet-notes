package io.ryanliang.ryanet.dao;

import io.ryanliang.ryanet.model.GenericModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImplementation<T extends GenericModel>
        implements GenericDaoInterface<T> {

    //private final Class<T> genericClassType;

    private SessionFactory sessionFactory;

    /*
    @Autowired
    @SuppressWarnings("unchecked")
    public AbstractDaoImpl(SessionFactory sessionFactory) {

        this.genericClassType = (Class<T>)GenericTypeResolver.resolveTypeArgument(getClass(),
                                                                          AbstractDaoImpl.class);
        this.sessionFactory = sessionFactory;
    }*/

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
