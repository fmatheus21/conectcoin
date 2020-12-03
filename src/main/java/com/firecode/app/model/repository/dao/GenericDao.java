package com.firecode.app.model.repository.dao;

import java.util.List;

public interface GenericDao<T> {

    void create(T t);

    void update(T t);

    T findById(int id);

    void deleteById(int id);

    List<T> findAllOrderBy(String orderBy);

}
