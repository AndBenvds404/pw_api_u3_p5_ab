package com.example.pw_api_u3_p5_ab.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pw_api_u3_p5_ab.repository.model.Profesor;

@Repository
public interface IProfesorRepository {
    // CRUD
    // Create, Read, Update (total y parcial), Delete
    public void insertar(Profesor profesor);
    public void actualizar(Profesor profesor);
    public void actualizarParcial(String apellido, String nombre, Integer id);
    public Profesor seleccionar(Integer id);
    public void eliminar(Integer id);
    public List<Profesor> consultarTodo(String genero) ;
    
}
