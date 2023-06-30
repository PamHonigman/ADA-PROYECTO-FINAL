package com.proyectofinal.libreria.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Long isbn;

    private String anioDeEdicion;
    private Integer cantidad;
    private Integer condicion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "libros_autores",
            joinColumns = @JoinColumn(name = "libros_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "autores_id", referencedColumnName = "id")
    )
    private List<Autor> autores;

    @ManyToMany(mappedBy = "librosPrestados")
    private List<Socio> socios;
    public Libro(){}

    public Libro(Long id, String titulo, Long isbn, String anioDeEdicion, Integer cantidad,
                 Integer condicion, List<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anioDeEdicion = anioDeEdicion;
        this.cantidad = cantidad;
        this.condicion = condicion;
        this.autores = autores;
    }

    public Libro(Long id, String titulo, Long isbn, String anioDeEdicion, Integer cantidad, Integer condicion,
                 List<Autor> autores, List<Socio> socios) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anioDeEdicion = anioDeEdicion;
        this.cantidad = cantidad;
        this.condicion = condicion;
        this.autores = autores;
        this.socios = socios;
    }

    public Libro(String titulo, Long isbn, String anioDeEdicion, Integer cantidad, Integer condicion,
                 List<Autor> autores) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.anioDeEdicion = anioDeEdicion;
        this.cantidad = cantidad;
        this.condicion = condicion;
        this.autores = autores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getAnioDeEdicion() {
        return anioDeEdicion;
    }

    public void setAnioDeEdicion(String anioDeEdicion) {
        this.anioDeEdicion = anioDeEdicion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCondicion() {
        return condicion;
    }

    public void setCondicion(Integer condicion) {
        this.condicion = condicion;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    @Override
    public String toString() {
        return titulo + " " + autores.toString() + " - " + anioDeEdicion;
    }
}
