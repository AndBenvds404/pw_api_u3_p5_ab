package com.example.pw_api_u3_p5_ab.service;

import java.util.List;

import com.example.pw_api_u3_p5_ab.service.to.Estudiante10TO;
import com.example.pw_api_u3_p5_ab.service.to.EstudianteLigeroTO;

public interface IEstudiante10Service {
    
    
    public void guardar (Estudiante10TO estudiante);
    public void actualizar(Estudiante10TO estudiante);
    public Estudiante10TO buscar(Integer id);
    public void borrar(Integer id);
    public List<Estudiante10TO>consultarTodoTO();
    public EstudianteLigeroTO buscarLigero(Integer id);
    
}
