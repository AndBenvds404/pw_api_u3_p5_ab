package com.example.pw_api_u3_p5_ab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p5_ab.repository.IProfesorRespository;
import com.example.pw_api_u3_p5_ab.repository.modelo.Profesor;

@Service
public class ProfesorServiceImpl  implements IProfesorService{

    @Autowired
	private IProfesorRespository profesorRepository;

    @Override
    public void guardar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.profesorRepository.insertar(profesor);
    }

    @Override
    public Profesor buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.profesorRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.profesorRepository.actualizar(profesor);
    }

    @Override
    public void actualizarDatosPersonales(Integer id, String materia, String salario) {
        // TODO Auto-generated method stub
        this.profesorRepository.actualizarParcial(id, materia, materia);
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.profesorRepository.eliminar(id);
    }

    @Override
    public List<Profesor> consultarMateria(String materia) {
        // TODO Auto-generated method stub
        return this.profesorRepository.consultarMateria(materia);
    }

    
}
