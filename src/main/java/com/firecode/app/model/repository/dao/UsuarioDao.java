package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.UsuarioEntity;
import com.firecode.app.model.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public abstract class UsuarioDao implements GenericDao<UsuarioEntity> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void create(UsuarioEntity t) {
        repository.save(t);
    }

    @Override
    public void update(UsuarioEntity t) {
        repository.save(t);
    }

    @Override
    public UsuarioEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<UsuarioEntity> findAllOrderBy(String orderBy) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, orderBy));
    }

    public Optional<UsuarioEntity> findByUsuario(String value) {
        return repository.findByUsuario(value);
    }

}
