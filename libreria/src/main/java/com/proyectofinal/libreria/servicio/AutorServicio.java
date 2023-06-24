package com.proyectofinal.libreria.servicio;

import com.proyectofinal.libreria.modelo.Autor;

import java.util.List;

public interface AutorServicio {

    public List<Autor> listarTodosLosAutores();

    public Autor guardarAutor(Autor autor);

    public Autor obtenerAutorPorId(Long id);

    public Autor actualizarAutor(Autor autor);

    public void eliminarAutor(Autor autor);

    List<Autor> buscarPorPalabraClave(String palabraClave);

}
