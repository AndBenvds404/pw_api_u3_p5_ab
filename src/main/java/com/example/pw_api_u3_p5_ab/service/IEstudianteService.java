package com.example.pw_api_u3_p5_ab.service;

import java.util.List;

import com.example.pw_api_u3_p5_ab.repository.modelo.Estudiante;
import com.example.pw_api_u3_p5_ab.service.to.EstudianteTo;

public interface IEstudianteService {
    
    public void guardar (Estudiante estudiante);
    public void actualizar(Estudiante estudiante);
    public void actualizarParcial(String apellido, String nombre, Integer Id);
    public Estudiante buscar(Integer id);
    public void borrar(Integer id);
    public List<Estudiante> buscarTodos(String genero);

    public List<EstudianteTo> buscarTodosTo();

}
