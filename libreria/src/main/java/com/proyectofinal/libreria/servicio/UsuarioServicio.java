package com.proyectofinal.libreria.servicio;

import com.proyectofinal.libreria.dto.UsuarioRegistroDTO;
import com.proyectofinal.libreria.modelo.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioServicio extends UserDetailsService {

    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    public List<Usuario> listarUsuarios();
}
