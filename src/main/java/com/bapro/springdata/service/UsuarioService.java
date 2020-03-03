package com.bapro.springdata.service;

import com.bapro.springdata.model.Rol;
import com.bapro.springdata.model.Usuario;
import com.bapro.springdata.repository.UsuarioJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario usuario = usuarioJpaRepository.findByUserName(userName);

        if (usuario == null ) throw new RuntimeException("Usuario no encontrado");


        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));

        //este User viene de spring security.
        return new org.springframework.security.core.userdetails.User(usuario.getUserName(),
                usuario.getPassword(), grantedAuthorities);
    }
}
