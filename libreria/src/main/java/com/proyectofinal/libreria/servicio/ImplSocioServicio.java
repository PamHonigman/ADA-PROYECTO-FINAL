package com.proyectofinal.libreria.servicio;

import com.proyectofinal.libreria.modelo.Socio;
import com.proyectofinal.libreria.repositorio.SocioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplSocioServicio implements SocioServicio{

    @Autowired
    private SocioRepositorio socioRepositorio;

    @Override
    public List<Socio> listarTodosLosSocios() {
        return socioRepositorio.findAll();
    }

    @Override
    public Socio guardarSocio(Socio socio) {
        return socioRepositorio.save(socio);
    }

    @Override
    public Socio obtenerSocioPorId(Long id) {
        return socioRepositorio.findById(id).get();
    }

    @Override
    public Socio actualizarSocio(Socio socio) {
        return socioRepositorio.save(socio);
    }

    @Override
    public void eliminarSocio(Socio socio) {
        socioRepositorio.delete(socio);
    }

    @Override
    public List<Socio> buscarSocio(String keyword) {
        return socioRepositorio.buscarSocio(keyword);
    }

}
