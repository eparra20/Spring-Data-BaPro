package com.bapro.springdata.dto;



/**
 * Esto es un POJO DTO (Data Transfer Object)
 * Sirve solo y unicamente para armar lo que necesitamos a la hora de crear un usuario.
 * Como por ejemplo recibir el String "ROL" para luego buscar el objeto en la base de datos.
 * Tambien podemos validarlo con las anotaciones @Valid @NotEmpty etc y no tocamos la Entity de Usuarios.
 */
public class UsuarioRequest {

    private String dni;

    private String nombre;

    private String apellido;

    private String userName;

    private String password;

    private Boolean activo;

    private String rol;

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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
