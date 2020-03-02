package com.bapro.springdata.controller;

import com.bapro.springdata.model.Usuario;
import com.bapro.springdata.repository.UsuarioJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping("peliculas")
public class PeliculaController {

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @GetMapping("")
    public String getPeliculas(Model model){
        return "pelicula/lista";
    }


}
