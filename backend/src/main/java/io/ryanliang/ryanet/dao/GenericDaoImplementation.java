package io.ryanliang.ryanet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;
import sun.net.www.content.text.Generic;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public abstract class GenericDaoImplementation<GenericClass, IDClass extends Serializable>
        implements GenericDao<GenericClass, IDClass> {

    private SessionFactory sessionFactory;
    private Class<GenericClass> genericType;

    @SuppressWarnings("unchecked")
    public GenericDaoImplementation() {

        this.genericType = (Class<GenericClass>) GenericTypeResolver.resolveTypeArguments(
                getClass(), GenericDao.class)[0];
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    Session getSession(){

        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public GenericClass persist(GenericClass entity) {

        this.getSession().persist(entity);
        return entity;
    }

    @Override
    public void delete(GenericClass entity) {

        this.getSession().delete(entity);
    }

    @Override
    public List<GenericClass> findAll() {

        CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
        CriteriaQuery<GenericClass> criteria = criteriaBuilder.createQuery(genericType);
        Root<GenericClass> root = criteria.from(genericType);
        CriteriaQuery<GenericClass> all = criteria.select(root);
        TypedQuery<GenericClass> allQuery = this.getSession().createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public GenericClass findOneByID(IDClass id) {

        CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
        CriteriaQuery<GenericClass> criteria = criteriaBuilder.createQuery(genericType);
        Root<GenericClass> genericRoot = criteria.from(genericType);
        criteria.where(criteriaBuilder.equal(genericRoot.get("id"), id));
        TypedQuery<GenericClass> query = this.getSession().createQuery(criteria);

        // since its id, it should be just one result.
        return query.getSingleResult();
    }

}
