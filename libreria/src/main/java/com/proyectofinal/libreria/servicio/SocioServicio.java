package com.proyectofinal.libreria.servicio;

import com.proyectofinal.libreria.modelo.Socio;

import java.util.List;

public interface SocioServicio {

    public List<Socio> listarTodosLosSocios();

    public Socio guardarSocio(Socio socio);

    public Socio obtenerSocioPorId(Long id);

    public Socio actualizarSocio(Socio socio);

    public void eliminarSocio(Socio socio);

    List<Socio> buscarSocio(String keyword);

}















