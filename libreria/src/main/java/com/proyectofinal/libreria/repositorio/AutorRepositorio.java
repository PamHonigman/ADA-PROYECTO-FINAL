package com.proyectofinal.libreria.repositorio;


import com.proyectofinal.libreria.modelo.Autor;
import com.proyectofinal.libreria.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE %:palabraClave% OR a.apellido LIKE %:palabraClave%")
    List<Autor> buscarPorPalabraClave(@Param("palabraClave") String palabraClave);

}
