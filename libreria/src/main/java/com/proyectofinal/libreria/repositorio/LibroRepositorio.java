package com.proyectofinal.libreria.repositorio;

import com.proyectofinal.libreria.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l JOIN l.autores a WHERE l.titulo LIKE %:palabraClave% OR a.nombre LIKE %:palabraClave% " +
            "OR a.apellido LIKE %:palabraClave%")
    List<Libro> buscarPorPalabraClave(@Param("palabraClave") String palabraClave);

}
