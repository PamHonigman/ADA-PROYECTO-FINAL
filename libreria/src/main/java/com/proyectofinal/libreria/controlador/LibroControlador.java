package com.proyectofinal.libreria.controlador;

import com.proyectofinal.libreria.modelo.Autor;
import com.proyectofinal.libreria.modelo.Libro;
import com.proyectofinal.libreria.servicio.AutorServicio;
import com.proyectofinal.libreria.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private AutorServicio autorServicio;

    @GetMapping("/libros")
    public String mostrarPaginaDeInicio(Model modelo){
        List<Libro> libros = libroServicio.listarTodosLosLibros();
        modelo.addAttribute("libros", libros);

        return "index";
    }

    @GetMapping("/libros/nuevo")
    public String mostrarFormularioRegistrarLibro(Model modelo){
        Libro libro = new Libro();
        List<Autor> listaAutores = autorServicio.listarTodosLosAutores();

        modelo.addAttribute("libro", new Libro());
        modelo.addAttribute("autores", listaAutores);

        return "agregar-libro";
    }

    @PostMapping("/libros/guardar")
    public String guardarLibro(@Validated Libro libro, BindingResult bindingResult, RedirectAttributes redirect,
                               Model modelo){

        if (bindingResult.hasErrors()) {
            modelo.addAttribute("libro", libro);
            return "agregar-libro";
        }

        libroServicio.guardarLibro(libro);

        redirect.addFlashAttribute("msgExito", "Libro añadido exitosamente!");

        return "redirect:/libros";
    }
    @GetMapping("/libros/editar/{id}")
    public String mostrarFormularioEditarLibro(@PathVariable Long id, Model modelo){
        Libro libro = libroServicio.obtenerLibroPorId(id);
        List<Autor> listaAutores = autorServicio.listarTodosLosAutores();

        modelo.addAttribute("libro", libro);
        modelo.addAttribute("autores", listaAutores);

        return "actualizar-libro";
    }

    @PostMapping("/libros/editar/{id}")
    public String actualizarLibro(@PathVariable Long id, @Validated Libro libro, BindingResult bindingResult,
                                  RedirectAttributes redirect, Model modelo){

        Libro libroDB = libroServicio.obtenerLibroPorId(id);

        if (bindingResult.hasErrors()){
            modelo.addAttribute("libro", libro);
            return "actualizar-libro";
        }

        libroDB.setTitulo(libro.getTitulo());
        libroDB.setAutores(libro.getAutores());
        libroDB.setAnioDeEdicion(libro.getAnioDeEdicion());
        libroDB.setIsbn(libro.getIsbn());
        libroDB.setCantidad(libro.getCantidad());
        libroDB.setCondicion(libro.getCondicion());

        libroServicio.actualizarLibro(libroDB);

        redirect.addFlashAttribute("msgExito", "Libro modificado exitosamente!");

        return "redirect:/libros";
    }

    @PostMapping("/libros/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id, RedirectAttributes redirect){
        Libro libro = libroServicio.obtenerLibroPorId(id);

        libroServicio.eliminarLibro(libro);

        redirect.addFlashAttribute("msgExito", "Libro eliminado exitosamente!");

        return "redirect:/libros";
    }

    @GetMapping("/search")
    public String buscar(@RequestParam("palabraClave") String palabraClave, Model model) {
        List<Libro> libros = libroServicio.buscarPorPalabraClave(palabraClave);
        List<Autor> autores = autorServicio.buscarPorPalabraClave(palabraClave);

        if (libros.isEmpty() && autores.isEmpty()) {
            model.addAttribute("mensajeError", "No se encontraron resultados para \"" + palabraClave + "\"");
        }   else {
            model.addAttribute("mensajeOk", "Resultados para la búsqueda de: \"" + palabraClave + "\"");
            model.addAttribute("libros", libros);
            model.addAttribute("autores", autores);
        }

        return "search";
    }
}















