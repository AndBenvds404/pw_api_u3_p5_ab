package com.example.pw_api_u3_p5_ab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p5_ab.repository.IEstudianteRepository;
import com.example.pw_api_u3_p5_ab.repository.model.Estudiante;
import com.example.pw_api_u3_p5_ab.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl  implements IEstudianteService{

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
    public EstudianteTO buscarTO(Integer id) {
        // TODO Auto-generated method stub
        return this.canvertir(this.buscar(id));
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.eliminar(id);
    }

    @Override
    public List<Estudiante> consultarTodo() {
        // TODO Auto-generated method stub
        return this.iEstudianteRepository.consultarTodo("f");
    }

    @Override
    public List<EstudianteTO> consultarTodoTO() {
        // TODO Auto-generated method stub
        var lista = iEstudianteRepository.consultarTodo("f");
        List<EstudianteTO> listaTO = new ArrayList<>();
        for(Estudiante e:lista){
            listaTO.add(canvertir(e));
        }
        return listaTO;
    }

    private EstudianteTO canvertir(Estudiante est){
        EstudianteTO estTO = new EstudianteTO();
        estTO.setNombre(est.getNombre());
        estTO.setApellido(est.getApellido());
        estTO.setGenero(est.getGenero());
        estTO.setFechaNacimiento(est.getFechaNacimiento());
        estTO.setId(est.getId());
        return estTO;
    }
}
