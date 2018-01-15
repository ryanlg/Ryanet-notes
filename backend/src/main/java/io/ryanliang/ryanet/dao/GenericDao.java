package io.ryanliang.ryanet.dao;

import javax.persistence.criteria.Selection;
import java.util.List;
import java.io.Serializable;

public interface GenericDao<GenericClass, IDClass extends Serializable> {

    List<GenericClass> findAll();
    GenericClass findOneByID(IDClass id);

    GenericClass persist(GenericClass entity);
    void delete(GenericClass entity);
}
