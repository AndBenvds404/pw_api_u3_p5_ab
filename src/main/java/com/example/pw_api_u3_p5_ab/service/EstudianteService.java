package com.example.pw_api_u3_p5_ab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p5_ab.repository.IEstudianteRepository;
import com.example.pw_api_u3_p5_ab.repository.modelo.Estudiante;

@Service
public class EstudianteService implements IEstudianteService{

    @Autowired
    private IEstudianteRepository iEstudianteRepository;

    @Override
    public void guardar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.insertar(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.actualizar(estudiante);
    }

    @Override
    public void actualizarParcial(String apellido, String nombre, Integer Id) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.actualizarParcial(apellido, nombre, Id);
    }

    @Override
    public Estudiante buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.iEstudianteRepository.seleccionar(id);
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.eliminar(id);
    }
    
}
