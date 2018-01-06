package io.ryanliang.ryanet.dao;

import java.util.List;
import java.io.Serializable;

public interface GenericDao<GenericClass, IDClass extends Serializable> {

    // GenericClass findById(ID id, boolean lock);

     List<GenericClass> findAll();
     GenericClass findOneByID(IDClass id);

    // List<GenericClass> findByExample(GenericClass exampleInstance);

    GenericClass persist(GenericClass entity);

    void delete(GenericClass entity);
}
