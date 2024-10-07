package com.ejemplo.proyectoprueba.service;

import com.ejemplo.datos.mapper.TareaMapper;
import com.ejemplo.datos.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    private TareaMapper tareaMapper;

    // Guardar una nueva tarea
    public void save(Tarea tarea) {
        if (tarea != null) {
            tareaMapper.insertTarea(tarea);
        } else {
            throw new IllegalArgumentException("La tarea no puede ser nula");
        }
    }

    // Obtener todas las tareas
    public List<Tarea> findAll() {
        return tareaMapper.getAllTareas();
    }

    // Buscar tarea por ID
    public Tarea findById(Long id) {
        return tareaMapper.getTareaById(id);
    }

    // Actualizar una tarea existente
    public void update(Tarea tarea) {
        if (tarea != null) {
            tareaMapper.updateTarea(tarea);
        } else {
            throw new IllegalArgumentException("La tarea no puede ser nula");
        }
    }

    // Eliminar una tarea por su ID
    public void delete(Long id) {
        if (id != null) {
            tareaMapper.deleteTarea(id);
        } else {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
    }
}
