package com.bapro.springdata.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bapro.springdata.model.Usuario;
import com.bapro.springdata.repository.UsuarioJpaRepository;

@RestController
@RequestMapping("usuarios")
public class UsuarioRestController {
	
	/**
	 * Con autowired le indicamos al framwork que nos traiga un objeto valido de tipo UsuarioJpaRepository
	 */
	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository;
	
	@GetMapping("")
	public List<Usuario> getUsuarios(){
		List<Usuario> usuarios = usuarioJpaRepository.findAll();
		return usuarios;
	}
	
	/**
	 * localhost:8080/usuario/1
	 * @param id
	 * @return
	 */
	@GetMapping("{id}")
	public Usuario getUsuarioById(@PathVariable("id") Integer id) {
		Optional<Usuario> unOptionalUsuario = usuarioJpaRepository.findById(id);
		return unOptionalUsuario.get();
	}
	
	@PostMapping("")
	public Usuario insertUsuario(@RequestBody Usuario unUsuarioARegistrar) {
		Usuario unUsuarioRegistrado = usuarioJpaRepository.save(unUsuarioARegistrar);
		return unUsuarioRegistrado;
	}
	
	@DeleteMapping("{id}")
	public Usuario deleteUsuario(@PathVariable("id") Integer id) {
		usuarioJpaRepository.deleteById(id);
		return null;
	}
	

}
