package com.proyectofinal.libreria.controlador;

import com.proyectofinal.libreria.modelo.Autor;
import com.proyectofinal.libreria.modelo.Libro;
import com.proyectofinal.libreria.modelo.Socio;
import com.proyectofinal.libreria.servicio.LibroServicio;
import com.proyectofinal.libreria.servicio.SocioServicio;
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

import java.util.Collection;
import java.util.List;

@Controller
public class SocioControlador {

    @Autowired
    private SocioServicio socioServicio;

    @Autowired
    private LibroServicio libroServicio;

    @GetMapping("/socios")
    public String mostrarListadoSocios(Model modelo){
        List<Socio> socios = socioServicio.listarTodosLosSocios();
        modelo.addAttribute("socios", socios);

        return "lista-socios";
    }

    @GetMapping("/socios/nuevo")
    public String mostrarFormularioRegistrarSocio(Model modelo){
        Socio socio = new Socio();
        List<Libro> listaLP = libroServicio.listarTodosLosLibros();

        modelo.addAttribute("socio", new Socio());
        modelo.addAttribute("librosPrestados", listaLP);

        return "agregar-socio";
    }

    @PostMapping("/socios/guardar")
    public String guardarSocio(@Validated Socio socio, BindingResult binding, RedirectAttributes redirect,
                               Model modelo ){

        if (binding.hasErrors()) {
            modelo.addAttribute("socio", socio);
            return "agregar-socio";
        }

        socioServicio.guardarSocio(socio);

        redirect.addFlashAttribute("msgExito", "Socio añadido exitosamente!");

        return "redirect:/socios";
    }

    @GetMapping("/socios/editar/{id}")
    public String mostrarFormularioEditarSocio(@PathVariable Long id, Model modelo){
        Socio socio = socioServicio.obtenerSocioPorId(id);
        List<Libro> listaLP = libroServicio.listarTodosLosLibros();

        modelo.addAttribute("socio", socio);
        modelo.addAttribute("librosPrestados", listaLP);

        return "actualizar-socio";
    }

    @PostMapping("/socios/editar/{id}")
    public String actualizarSocio(@PathVariable Long id, @Validated Socio socio, BindingResult binding,
                                  RedirectAttributes redirect, Model modelo ){

        Socio socioDB = socioServicio.obtenerSocioPorId(id);

        if (binding.hasErrors()) {
            modelo.addAttribute("socio", socio);
            return "agregar-socio";
        }

        socioDB.setNombre(socio.getNombre());
        socioDB.setApellido(socio.getApellido());
        socioDB.setDni(socio.getDni());
        socioDB.setTelefono(socio.getTelefono());
        socioDB.setLibrosPrestados(socio.getLibrosPrestados());

        socioServicio.actualizarSocio(socioDB);

        redirect.addFlashAttribute("msgExito", "Socio modificado exitosamente!");

        return "redirect:/socios";
    }

    @PostMapping("/socios/eliminar/{id}")
    public String eliminarSocio(@PathVariable Long id, RedirectAttributes redirect){
        Socio socio = socioServicio.obtenerSocioPorId(id);

        socioServicio.eliminarSocio(socio);

        redirect.addFlashAttribute("msgExito", "Socio eliminado exitosamente!");

        return "redirect:/socios";
    }

    @GetMapping("/search/socios")
    public String buscarSocio(@RequestParam("keyword") String keyword, Model model) {
        List<Socio> socios = socioServicio.buscarSocio(keyword);

        model.addAttribute("socios", socios);

        return "search-socios";
    }
}
