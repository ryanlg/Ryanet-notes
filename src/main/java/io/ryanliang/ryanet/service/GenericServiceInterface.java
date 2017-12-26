package io.ryanliang.ryanet.service;

public interface GenericServiceInterface<GenericClass> {

    GenericClass save(GenericClass entity);
    GenericClass delete(GenericClass entity);
}
