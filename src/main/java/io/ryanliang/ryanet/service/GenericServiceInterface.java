package io.ryanliang.ryanet.service;

import io.ryanliang.ryanet.model.GenericModel;

public interface GenericServiceInterface<GenericClass> {

    GenericClass save(GenericClass entity);
    GenericClass delete(GenericClass entity);
}
