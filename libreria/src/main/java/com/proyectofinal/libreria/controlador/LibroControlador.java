package com.proyectofinal.libreria.controlador;

import com.proyectofinal.libreria.modelo.Libro;
import com.proyectofinal.libreria.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @GetMapping("/libros")
    public String mostrarPaginaDeInicio(Model modelo){
        List<Libro> libros = libroServicio.listarTodosLosLibros();
        modelo.addAttribute("libros", libros);

        return "index";
    }

    @GetMapping("/nuevo-libro")
    public String mostrarFormularioRegsitrarLibro(Model modelo){
        modelo.addAttribute("libro", new Libro());

        return "agregar-libro";
    }

    @PostMapping("/guardar-libro")
    public String guardarLibro(@Validated Libro libro, BindingResult bindingResult, RedirectAttributes redirect,
                               Model modelo){

        if (bindingResult.hasErrors()) {
            modelo.addAttribute("libro", libro);
            return "agregar-libro";
        }

        libroServicio.guardarLibro(libro);

        redirect.addFlashAttribute("msgExito", "El libro ha sido añadido exitosamente!");

        return "redirect:/libros";
    }
    @GetMapping("/edicion-de-libro/{id}")
    public String mostrarFormularioEditarLibro(@PathVariable Long id, Model modelo){
        Libro libro = libroServicio.obtenerLibroPorId(id);
        modelo.addAttribute("libro", libro);

        return "actualizar-libro";
    }

    @PostMapping("/edicion-de-libro/{id}")
    public String actualizarLibro(@PathVariable Long id, @Validated Libro libro, BindingResult bindingResult,
                                  RedirectAttributes redirect, Model modelo){

        Libro libroDB = libroServicio.obtenerLibroPorId(id);

        if (bindingResult.hasErrors()){
            modelo.addAttribute("libro", libro);
            return "actualizar-libro";
        }

        libroDB.setTitulo(libro.getTitulo());
        libroDB.setAutores(libro.getAutores());
        libroDB.setAñoDeEdicion(libro.getAñoDeEdicion());
        libroDB.setIsbn(libro.getIsbn());
        libroDB.setCantidad(libro.getCantidad());
        libroDB.setCondicion(libro.getCondicion());

        libroServicio.actualizarLibro(libroDB);

        redirect.addFlashAttribute("msgExito", "El libro ha sido modificado exitosamente!");

        return "redirect:/libros";
    }

    public String eliminarLibro(@PathVariable Long id, RedirectAttributes redirect){
        Libro libro = libroServicio.obtenerLibroPorId(id);

        libroServicio.eliminarLibro(libro);

        redirect.addFlashAttribute("msgExito", "El libro ha sido eliminado exitosamente!");

        return "redirect:/libros";
    }







}















