package com.ejemplo.datos.mapper;

import com.ejemplo.datos.model.Tarea;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TareaMapper {

    @Insert("INSERT INTO tareas (nombre, descripcion, fechaInicio) VALUES (#{nombre}, #{descripcion}, #{fechaInicio})")
    void insertTarea(Tarea tarea);

    @Select("SELECT * FROM tareas WHERE id = #{id}")
    Tarea getTareaById(Long id);

    @Select("SELECT * FROM tareas")
    List<Tarea> getAllTareas();

    @Update("UPDATE tareas SET nombre = #{nombre}, descripcion = #{descripcion}, fechaInicio = #{fechaInicio} WHERE id = #{id}")
    void updateTarea(Tarea tarea);

    @Delete("DELETE FROM tareas WHERE id = #{id}")
    void deleteTarea(Long id);
}
