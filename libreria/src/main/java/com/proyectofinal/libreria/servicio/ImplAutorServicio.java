package com.proyectofinal.libreria.servicio;

import com.proyectofinal.libreria.modelo.Autor;
import com.proyectofinal.libreria.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplAutorServicio implements AutorServicio{

    @Autowired
    private AutorRepositorio autorRepositorio;


    @Override
    public List<Autor> listarTodosLosAutores() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepositorio.save(autor);
    }

    @Override
    public Autor obtenerAutorPorId(Long id) {
        return autorRepositorio.findById(id).get();
    }

    @Override
    public Autor actualizarAutor(Autor autor) {
        return autorRepositorio.save(autor);
    }

    @Override
    public void eliminarAutor(Autor autor) {
        autorRepositorio.delete(autor);
    }

    @Override
    public List<Autor> buscarPorPalabraClave(String palabraClave) {
        return autorRepositorio.buscarPorPalabraClave(palabraClave);
    }
}
