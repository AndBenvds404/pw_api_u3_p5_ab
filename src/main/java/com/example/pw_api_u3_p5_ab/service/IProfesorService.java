package com.example.pw_api_u3_p5_ab.service;

import java.util.List;

import com.example.pw_api_u3_p5_ab.repository.model.Profesor;

public interface IProfesorService {
    public void guardar (Profesor profesor);
    public void actualizar(Profesor profesor);
    public void actualizarParcial(String apellido, String nombre, Integer Id);
    public Profesor buscar(Integer id);
    public void borrar(Integer id);
    public List<Profesor>consultarTodo(String genero);
    
}
