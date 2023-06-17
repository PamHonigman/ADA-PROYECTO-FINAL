package com.proyectofinal.libreria.modelo;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;

    private String apellido;

    @NotBlank(message = "Este campo no puede quedar vacío. Si no existe la información, ingrese: Desconocido")
    private String lugarDeNacimiento;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "No puede ser una fecha posterior a la actual")
    @NotNull(message = "Este campo no puede quedar vacío. Si no existe la información, ingrese: 01/01/0001")
    private LocalDate fechaNacimiento;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(Long id, String nombre, String apellido, String lugarDeNacimiento, LocalDate fechaNacimiento, List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.lugarDeNacimiento = lugarDeNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.libros = libros;
    }

    public Autor(String nombre, String apellido, String lugarDeNacimiento, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.lugarDeNacimiento = lugarDeNacimiento;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getLugarDeNacimiento() {
        return lugarDeNacimiento;
    }

    public void setLugarDeNacimiento(String lugarDeNacimiento) {
        this.lugarDeNacimiento = lugarDeNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }




}
