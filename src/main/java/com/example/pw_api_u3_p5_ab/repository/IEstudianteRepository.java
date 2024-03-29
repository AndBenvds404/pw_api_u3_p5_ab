package com.example.pw_api_u3_p5_ab.repository;

import com.example.pw_api_u3_p5_ab.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    public void insertar (Estudiante estudiante);
    public void actualizar(Estudiante estudiante);
    public void actualizarParcial(String apellido, String nombre, Integer Id);
    public Estudiante seleccionar(Integer id);
    public void eliminar(Integer id);

    

    
}
