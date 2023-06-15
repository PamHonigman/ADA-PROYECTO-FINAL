package com.proyectofinal.libreria.controlador;

import com.proyectofinal.libreria.modelo.Autor;
import com.proyectofinal.libreria.servicio.AutorServicio;
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
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/autores")
    public String mostrarListadoAutores(Model modelo){
        List<Autor> autores = autorServicio.listarTodosLosAutores();
        modelo.addAttribute("autores", autores);

        return "lista-autores";
    }

    @GetMapping("/autores/nuevo")
    public String mostrarFormularioRegistrarAutor(Model modelo){
        modelo.addAttribute("autor", new Autor());

        return "agregar-autor";
    }

    @PostMapping("/autores/guardar")
    public String guardarAutor(@Validated Autor autor, BindingResult bindingResult, RedirectAttributes redirect,
                               Model modelo){

        if (bindingResult.hasErrors()) {
            modelo.addAttribute("autor", autor);
            return "agregar-autor";
        }

        autorServicio.guardarAutor(autor);

        redirect.addFlashAttribute("msgExito", "Autor añadido exitosamente!");

        return "redirect:/autores";
    }

    @GetMapping("/autores/editar/{id}")
    public String mostrarFormularioEditarAutor(@PathVariable Long id, Model modelo){
        Autor autor = autorServicio.obtenerAutorPorId(id);
        modelo.addAttribute("autor", autor);

        return "actualizar-autor";
    }

    @PostMapping("/autores/editar/{id}")
    public String actualizarAutor(@PathVariable Long id, @Validated Autor autor, BindingResult bindingResult,
                                  RedirectAttributes redirect, Model modelo){

        Autor autorDB = autorServicio.obtenerAutorPorId(id);

        if (bindingResult.hasErrors()){
            modelo.addAttribute("autor", autor);
            return "actualizar-autor";
        }

        autorDB.setNombre(autor.getNombre());
        autorDB.setApellido(autor.getApellido());
        autorDB.setLugarDeNacimiento(autor.getLugarDeNacimiento());
        autorDB.setFechaNacimiento(autor.getFechaNacimiento());

        autorServicio.actualizarAutor(autorDB);

        redirect.addFlashAttribute("msgExito", "Autor modificado exitosamente!");

        return "redirect:/autores";
    }

    @PostMapping("/autores/eliminar/{id}")
    public String eliminarAutor(@PathVariable Long id, RedirectAttributes redirect){
        Autor autor = autorServicio.obtenerAutorPorId(id);

        autorServicio.eliminarAutor(autor);

        redirect.addFlashAttribute("msgExito", "Autor eliminado exitosamente!");

        return "redirect:/autores";
    }













}
