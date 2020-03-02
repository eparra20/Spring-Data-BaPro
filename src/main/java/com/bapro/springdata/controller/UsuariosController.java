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
@RequestMapping("usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @GetMapping("")
    public String getUsuarios(Model model){
        List<Usuario> usuarios = usuarioJpaRepository.findAll();
        model.addAttribute("usuarios",usuarios);
        return "usuario/lista";
    }

    @GetMapping("crear")
    public String crearUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/crear";
    }

    @PostMapping("crear")
    public String crearUsuarioPost(Usuario usuario){
        usuarioJpaRepository.save(usuario);
        return "redirect:/usuarios";
    }
}
