package com.firecode.app.controller.security;

import com.firecode.app.model.entity.UsuarioEntity;
import com.firecode.app.model.service.UsuarioService;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
@Controller
public class AppUserDetailsSecurity implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(AppUserDetailsSecurity.class);

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioEntity> optional = usuarioService.findByUsuario(username);
        UsuarioEntity usuario = optional.orElseThrow(() -> new UsernameNotFoundException(null));

        if (usuario != null) {
            log.info("Usuario logado.");
        } else if (usuario == null) {
            log.info("Usuario ou senha incorretos.");
        }

        return new AppUserSecurity(usuario, this.authorities(usuario));
    }

    private Collection<? extends GrantedAuthority> authorities(UsuarioEntity usuario) {
        Set<SimpleGrantedAuthority> authoritys = new HashSet<>();
        usuario.getPermissoes().forEach(p -> authoritys.add(new SimpleGrantedAuthority(p.getNome().toUpperCase())));
        return authoritys;
    }

}
