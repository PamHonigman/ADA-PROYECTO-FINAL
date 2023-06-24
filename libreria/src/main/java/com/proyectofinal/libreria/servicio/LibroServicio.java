package com.proyectofinal.libreria.servicio;

import com.proyectofinal.libreria.modelo.Libro;

import java.util.List;

public interface LibroServicio {

    public List<Libro> listarTodosLosLibros();

    public Libro guardarLibro(Libro libro);

    public Libro obtenerLibroPorId(Long id);

    public Libro actualizarLibro(Libro libro);

    public void eliminarLibro(Libro libro);

    List<Libro> buscarPorPalabraClave(String palabraClave);
}
