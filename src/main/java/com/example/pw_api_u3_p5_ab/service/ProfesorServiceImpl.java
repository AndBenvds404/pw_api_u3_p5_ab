package com.example.pw_api_u3_p5_ab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p5_ab.repository.IProfesorRepository;
import com.example.pw_api_u3_p5_ab.repository.model.Profesor;

@Service
public class ProfesorServiceImpl  implements IProfesorService{
    @Autowired
    private IProfesorRepository iProfesorRepository;

    @Override
    public void guardar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.iProfesorRepository.insertar(profesor);
    }

    @Override
    public void actualizar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.iProfesorRepository.actualizar(profesor);
    }

    @Override
    public void actualizarParcial(String apellido, String nombre, Integer Id) {
        // TODO Auto-generated method stub
        this.iProfesorRepository.actualizarParcial(apellido, nombre, Id);
    }

    @Override
    public Profesor buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.iProfesorRepository.seleccionar(id);
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.iProfesorRepository.eliminar(id);
    }

    @Override
    public List<Profesor> consultarTodo(String genero) {
        // TODO Auto-generated method stub
        return this.iProfesorRepository.consultarTodo(genero);
    }
}
