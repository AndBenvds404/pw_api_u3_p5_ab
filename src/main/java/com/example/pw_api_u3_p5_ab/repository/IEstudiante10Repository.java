package com.example.pw_api_u3_p5_ab.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pw_api_u3_p5_ab.repository.model.Estudiante10;

@Repository
public interface IEstudiante10Repository {
    public void insertar(Estudiante10 estudiante);
    public void actualizar(Estudiante10 estudiante);
    public Estudiante10 buscar(Integer id);
    public void eliminar(Integer id);
    public List<Estudiante10> consultarTodo() ;
    
}
