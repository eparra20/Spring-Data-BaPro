package com.bapro.springdata.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Tabla o Entidad Usuario
 * @author Eduar
 *
 */
@Entity
public class Usuario {

	/**
	 * Esta sera nuestra Primary KEY que adicionalmente estamos indicando que sera AUTO_INCREMENT
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String dni;
	
	@Column(nullable = false)
	private String nombre;
	
	private String apellido;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private String password;


	@Column(nullable = false)
	private Boolean activo;

	@ManyToOne
	private Rol rol;

	public Usuario() {
	}

	public Usuario(Integer id, String dni, String nombre, String apellido, Boolean activo) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.activo = activo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
