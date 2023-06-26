package com.proyectofinal.libreria.repositorio;

import com.proyectofinal.libreria.modelo.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepositorio extends JpaRepository<Socio, Long> {
}
