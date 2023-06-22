package com.proyectofinal.libreria.dto;

import javax.validation.constraints.*;

public class UsuarioRegistroDTO {

    private Long id;

    @NotBlank(message = "Debe ingresar su/s nombre/s")
    private String nombre;

    @NotBlank(message = "Debe ingresar su apellido")
    private String apellido;

    @NotNull(message = "Debe ingresar un teléfono de contacto")
    private String telefono;

    @NotBlank(message = "Debe ingresar un correo electrónico")
    private String email;

    @NotBlank(message = "Debe ingresar una contraseña")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(regexp = ".*[A-Z].*", message = "La contraseña debe contener al menos una letra mayúscula")
    private String password;

    public UsuarioRegistroDTO() {
    }

    public UsuarioRegistroDTO(Long id, String nombre, String apellido, String telefono, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String nombre, String apellido, String telefono, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
