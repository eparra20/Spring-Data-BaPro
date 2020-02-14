package com.bapro.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bapro.springdata.model.Usuario;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario, Integer>{

}
