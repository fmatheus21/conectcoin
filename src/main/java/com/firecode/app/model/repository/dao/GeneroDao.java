package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.GeneroEntity;
import com.firecode.app.model.repository.GeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public abstract class GeneroDao implements GenericDao<GeneroEntity> {

    @Autowired
    private GeneroRepository repository;

    @Override
    public void create(GeneroEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(GeneroEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneroEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GeneroEntity> findAllOrderBy(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

}
