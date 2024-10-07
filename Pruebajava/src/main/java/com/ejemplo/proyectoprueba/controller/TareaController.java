package com.ejemplo.proyectoprueba.controller;

import com.ejemplo.datos.mapper.TareaMapper;
import com.ejemplo.datos.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private TareaMapper tareaMapper;

    @GetMapping("/")
    public String mostrarInicio(Model model) {
        model.addAttribute("title", "Bienvenido a la aplicación de tareas");
        return "home"; // nombre de la vista de inicio
    }

    @GetMapping("/crear")
    public String mostrarFormulario(Model model) {
        model.addAttribute("tarea", new Tarea());
        return "create"; // nombre de la vista
    }

    @PostMapping("/guardar")
    public String guardarTarea(@Valid @ModelAttribute Tarea tarea, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Imprimir errores en la consola para depurar
            System.out.println("Errores en el formulario:");
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getDefaultMessage());
            });

            model.addAttribute("error", "Errores en el formulario");
            return "create";
        }

        try {
            tareaMapper.insertTarea(tarea);
            return "redirect:/tarea/listar";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la tarea: " + e.getMessage());
            return "create";
        }
    }

    @GetMapping("/listar")
    public String listarTareas(Model model) {
        try {
            List<Tarea> tareas = tareaMapper.getAllTareas();
            if (tareas == null || tareas.isEmpty()) {
                model.addAttribute("error", "No hay tareas disponibles");
            } else {
                model.addAttribute("tareas", tareas);
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar las tareas: " + e.getMessage());
        }
        return "list"; // nombre de la vista
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Tarea tarea = tareaMapper.getTareaById(id);
        if (tarea == null) {
            model.addAttribute("error", "Tarea no encontrada");
            return "list"; // Redirigir a la lista si no se encuentra la tarea
        }
        model.addAttribute("tarea", tarea);
        return "edit"; // nombre de la vista para editar
    }

    @PostMapping("/actualizar")
    public String actualizarTarea(@ModelAttribute Tarea tarea, Model model) {
        try {
            tareaMapper.updateTarea(tarea);
            return "redirect:/tarea/listar"; // Redirigir después de actualizar
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar la tarea: " + e.getMessage());
            return "edit"; // Regresar al formulario si hay un error
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        tareaMapper.deleteTarea(id);
        return "redirect:/tarea/listar"; // Redirigir después de eliminar
    }
}
