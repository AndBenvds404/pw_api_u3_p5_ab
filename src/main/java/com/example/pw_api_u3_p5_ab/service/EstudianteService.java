package com.example.pw_api_u3_p5_ab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p5_ab.repository.IEstudianteRepository;
import com.example.pw_api_u3_p5_ab.repository.modelo.Estudiante;
import com.example.pw_api_u3_p5_ab.service.to.EstudianteTo;

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

    @Override
    public List<Estudiante> buscarTodos(String genero) {
        // TODO Auto-generated method stub
        return this.iEstudianteRepository.buscarTodos(genero);
    }

    @Override
    public List<EstudianteTo> buscarTodosTo() {
        // TODO Auto-generated method stub
        List<Estudiante> lista = this.iEstudianteRepository.buscarTodos("m");
        List<EstudianteTo> listaFinal = new ArrayList<>();
        for (Estudiante estudianteTo : lista) {
            listaFinal.add(this.convertir(estudianteTo));
        }
        
        return listaFinal;
    }

    private EstudianteTo convertir (Estudiante estudiante){
        
        EstudianteTo estudianteTo = new EstudianteTo();
        estudianteTo.setApellido(estudiante.getApellido());
        estudianteTo.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteTo.setGenero(estudiante.getGenero());
        estudianteTo.setNombre(estudiante.getNombre());
        estudianteTo.setId(estudiante.getId());
        return estudianteTo;

        
    }

    
    
}
