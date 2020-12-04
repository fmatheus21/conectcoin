package com.firecode.app.controller.security;

import com.firecode.app.controller.util.AppUtil;
import com.firecode.app.controller.util.NumberFormatUtil;
import com.firecode.app.model.entity.UsuarioEntity;
import java.math.BigDecimal;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AppUserSecurity extends User {

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

    public int getPontos() {
        if (usuario.getPessoaEntity().getClienteEntity() != null) {
            return usuario.getPessoaEntity().getClienteEntity().getPontuacaoEntity().getPontuacao();
        } else {
            return 0;
        }
    }

    public String getPatrocinador() {
        if (usuario.getPessoaEntity().getClienteEntity() != null) {
            return usuario.getPessoaEntity().getClienteEntity().getIdPatrocinador().getIdPessoa().getNomeRasaosocial();
        } else {
            return "Não tem patrocinador.";
        }
    }

    public String getSaldoDisponivel() {
        if (usuario.getPessoaEntity().getClienteEntity() != null) {
            BigDecimal saldoDisponivl = usuario.getPessoaEntity().getClienteEntity().getContaEntity().getSaldoDisponivel();
            return NumberFormatUtil.formatMoney(saldoDisponivl, 2, 2);
        } else {
            return "R$ 0,00";
        }
    }

}
