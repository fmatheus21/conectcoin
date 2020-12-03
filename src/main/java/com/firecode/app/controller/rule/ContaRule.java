package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.PerfilDto;
import com.firecode.app.controller.security.AppUserSecurity;
import com.firecode.app.model.entity.GeneroEntity;
import com.firecode.app.model.service.GeneroService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaRule {

    @Autowired
    private GeneroService generoService;

    public Collection<GeneroEntity> listarGeneros() {
        return generoService.findAllOrderBy("nome");
    }

    public PerfilDto carregaClienteLogado(AppUserSecurity appUserSecurity) {
        return PerfilDto.converterObject(appUserSecurity.getUsuario().getPessoaEntity().getClienteEntity());
    }

}
