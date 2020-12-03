package com.firecode.app.controller.security;

import com.firecode.app.model.entity.UsuarioEntity;
import java.util.Collection;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AppUserSecurity extends User {

    @Getter
    private final UsuarioEntity usuario;

    public AppUserSecurity(UsuarioEntity usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getUsuario(), usuario.getSenha(), authorities);
        this.usuario = usuario;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public String getUserName() {
        return usuario.getUsuario();
    }

    public String getNomeCompleto() {
        return usuario.getPessoaEntity().getNomeRasaosocial();
    }

}
