package com.bapro.springdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String dni;
	
	@Column(nullable = false)
	private String nombre;
	
	private String apellido;
	
	@Column(nullable = false)
	private Boolean activo;
	
	public Usuario() {
		
	}
	

	public Usuario(Integer id, String dni, String nombre, String apellido, Boolean activo) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.activo = activo;
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
	
	
}
