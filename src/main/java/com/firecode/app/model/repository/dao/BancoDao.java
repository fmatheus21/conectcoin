package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.BancoEntity;
import com.firecode.app.model.repository.BancoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public abstract class BancoDao implements GenericDao<BancoEntity> {

    @Autowired
    private BancoRepository repository;

    @Override
    public void create(BancoEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BancoEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BancoEntity findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BancoEntity> findAllOrderBy(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

}
