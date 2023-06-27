package com.proyectofinal.libreria.repositorio;

import com.proyectofinal.libreria.modelo.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocioRepositorio extends JpaRepository<Socio, Long> {

    //Para la búsqueda de socio en lista-socios
    @Query("SELECT s FROM Socio s WHERE CONCAT (s.id, s.nombre, s.apellido, s.dni, s.telefono) LIKE %:keyword%")
    List<Socio> buscarSocio(@Param("keyword") String keyword);
}
