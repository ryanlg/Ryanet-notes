package io.ryanliang.ryanet.service;

import java.util.List;

public interface GenericService<GenericClass, IDClass> {

    GenericClass save(GenericClass entity);
    GenericClass delete(GenericClass entity);

    List<GenericClass> findAll();
    GenericClass findOneByID(IDClass id);
}
