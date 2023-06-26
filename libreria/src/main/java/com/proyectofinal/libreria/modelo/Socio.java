package com.proyectofinal.libreria.modelo;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
@Table(name = "socios")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(6) ZEROFILL")
    private Long id;

    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;

    @NotBlank(message = "Debe ingresar un apellido")
    private String apellido;

    @NotNull(message = "Debe ingresar un número de documento")
    private Long dni;

    @NotBlank(message = "Debe ingresar un teléfono de contacto")
    private String telefono;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "socios_libros",
            joinColumns = @JoinColumn(name = "socios_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "libros_id", referencedColumnName = "id")
    )
    private Collection<Libro> librosPrestados;

    public Socio(){}

    public Socio(Long id, String nombre, String apellido, Long dni, String telefono, Collection<Libro> librosPrestados) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.librosPrestados = librosPrestados;
    }

    public Socio(String nombre, String apellido, Long dni, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Socio(Collection<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
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

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Collection<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(Collection<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }
}
