package io.ryanliang.ryanet.dao;

public interface GenericDaoInterface<T> {

    // T findById(ID id, boolean lock);

    // List<T> findAll();

    // List<T> findByExample(T exampleInstance);

    T persist(T entity);

    void delete(T entity);
}
