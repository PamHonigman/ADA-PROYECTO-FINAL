package com.proyectofinal.libreria.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private Long isbn;
    private Integer añoDeEdicion;
    private Integer cantidad;
    private String condicion;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "libros_autores",
            joinColumns = @JoinColumn(name = "libros_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "autores_id", referencedColumnName = "id")
    )
    private Collection<Autor> autores;

    public Libro(){}

    public Libro(Long id, String titulo, String autor, Long isbn, Integer añoDeEdicion, Integer cantidad,
                 String condicion, Collection<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.añoDeEdicion = añoDeEdicion;
        this.cantidad = cantidad;
        this.condicion = condicion;
        this.autores = autores;
    }

    public Libro(String titulo, String autor, Long isbn, Integer añoDeEdicion, Integer cantidad, String condicion,
                 Collection<Autor> autores) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.añoDeEdicion = añoDeEdicion;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Integer getAñoDeEdicion() {
        return añoDeEdicion;
    }

    public void setAñoDeEdicion(Integer añoDeEdicion) {
        this.añoDeEdicion = añoDeEdicion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Collection<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Collection<Autor> autores) {
        this.autores = autores;
    }

}
