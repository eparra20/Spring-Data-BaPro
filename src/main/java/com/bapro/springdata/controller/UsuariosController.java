package com.bapro.springdata.controller;

import com.bapro.springdata.dto.UsuarioRequest;
import com.bapro.springdata.model.Rol;
import com.bapro.springdata.model.Usuario;
import com.bapro.springdata.repository.RolJpaRepository;
import com.bapro.springdata.repository.UsuarioJpaRepository;
import com.bapro.springdata.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller()
@RequestMapping("usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    @Autowired
    private RolJpaRepository rolJpaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("")
    public String getUsuarios(Model model){
        List<Usuario> usuarios = usuarioJpaRepository.findAll();
        model.addAttribute("usuarios",usuarios);
        return "usuario/lista";
    }

    @GetMapping("crear")
    public String crearUsuario(Model model){
        model.addAttribute("usuario", new UsuarioRequest());
        return "usuario/crear";
    }

    @PostMapping("crear")
    public String crearUsuarioPost(UsuarioRequest usuarioRequest){
        Usuario usuario = mapUsuarioFromRequest(usuarioRequest);
        usuarioJpaRepository.save(usuario);
        return "redirect:/usuarios";
    }

    /**
     * Metodo para mapear el usuarioRequest recibido a Usuario de la base de datos.
     * Para esto buscamos en la base de datos el ROL recibido a partir del string y encryptamos la password.
     * @param usuarioRequest
     * @return
     */
    public Usuario mapUsuarioFromRequest(UsuarioRequest usuarioRequest){
        Usuario usuario = new Usuario();
        usuario.setDni(usuarioRequest.getDni());
        usuario.setNombre(usuarioRequest.getNombre());
        usuario.setApellido(usuarioRequest.getApellido());
        usuario.setUserName(usuarioRequest.getUserName());
        usuario.setPassword(passwordEncoder.encode(usuarioRequest.getPassword()));
        usuario.setActivo(usuarioRequest.getActivo());

        Rol rolDesdeLaBaseDeDatos = rolJpaRepository.findByNombre(usuarioRequest.getRol());
        usuario.setRol(rolDesdeLaBaseDeDatos);

        return usuario;
    }


}
