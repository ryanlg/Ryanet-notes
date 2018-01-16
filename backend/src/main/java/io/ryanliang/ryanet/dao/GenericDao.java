package io.ryanliang.ryanet.dao;

import javax.persistence.Tuple;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.Attribute;
import java.util.List;
import java.io.Serializable;

public interface GenericDao<GenericClass, IDClass extends Serializable> {

    List<GenericClass> findAll();
    GenericClass findOneByID(IDClass id);
    List<Tuple> findTuplesByColumns(Attribute[] columns);

    GenericClass persist(GenericClass entity);
    void delete(GenericClass entity);
}
