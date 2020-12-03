package com.firecode.app.model.service;

import com.firecode.app.model.entity.UsuarioEntity;
import com.firecode.app.model.repository.dao.UsuarioDao;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends UsuarioDao {

    @Override
    public Optional<UsuarioEntity> findByUsuario(String value) {
        return super.findByUsuario(value);
    }

}
