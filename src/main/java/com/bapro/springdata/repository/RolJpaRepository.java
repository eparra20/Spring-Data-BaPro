package com.bapro.springdata.repository;

import com.bapro.springdata.model.Rol;
import com.bapro.springdata.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolJpaRepository extends JpaRepository<Rol, Integer>{

    Rol findByNombre(String nombre);

}
