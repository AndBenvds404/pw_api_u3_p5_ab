package com.example.pw_api_u3_p5_ab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p5_ab.repository.IEstudiante10Repository;
import com.example.pw_api_u3_p5_ab.repository.model.Estudiante10;
import com.example.pw_api_u3_p5_ab.service.to.Estudiante10TO;
import com.example.pw_api_u3_p5_ab.service.to.EstudianteLigeroTO;


@Service
public class Estudiante10ServiceImpl implements IEstudiante10Service{

    @Autowired
    private IEstudiante10Repository iEstudiante10Repository;

    @Override
    public void guardar(Estudiante10TO estudiante) {
        // TODO Auto-generated method stub
        this.iEstudiante10Repository.insertar(this.toConvertiEstudiante(estudiante));    
    }

    @Override
    public void actualizar(Estudiante10TO estudiante) {
        // TODO Auto-generated method stub
        this.iEstudiante10Repository.actualizar(this.toConvertiEstudiante(estudiante));
    }

    @Override
    public Estudiante10TO buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.estudanteConvertirTO(this.iEstudiante10Repository.buscar(id));
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.iEstudiante10Repository.eliminar(id);
    }

    @Override
    public List<Estudiante10TO> consultarTodoTO() {
        // TODO Auto-generated method stub
        var ls = this.iEstudiante10Repository.consultarTodo();
        List<Estudiante10TO> lsTO = new ArrayList<>();
        for (Estudiante10 est : ls) {
            lsTO.add(this.estudanteConvertirTO(est));
        }
        return lsTO;
    }

    @Override
    public EstudianteLigeroTO buscarLigero(Integer id) {
        // TODO Auto-generated method stub
        return this.convertirLigero(this.iEstudiante10Repository.buscar(id));
    }

    //normal -> TO 
    private Estudiante10TO estudanteConvertirTO(Estudiante10 est){
        Estudiante10TO estTO = new Estudiante10TO();
        estTO.setId(est.getId());
        estTO.setNombre(est.getNombre());
        estTO.setApellido(est.getApellido());
        estTO.setCedula(est.getCedula());
        estTO.setGenero(est.getGenero());
        estTO.setFechaNacimiento(est.getFechaNacimiento());
        estTO.setSangre(est.getSangre());
        estTO.setMatricula(est.getMatricula());
        estTO.setSemestre(est.getSemestre());
        estTO.setGratuidad(est.getGratuidad());
        return estTO;
    }

    //TO -> normal 
    private Estudiante10 toConvertiEstudiante(Estudiante10TO estTO){
        Estudiante10 est = new Estudiante10();
        est.setId(estTO.getId());
        est.setNombre(estTO.getNombre());
        est.setApellido(estTO.getApellido());
        est.setCedula(estTO.getCedula());
        est.setGenero(estTO.getGenero());
        est.setFechaNacimiento(estTO.getFechaNacimiento());
        est.setSangre(estTO.getSangre());
        est.setMatricula(estTO.getMatricula());
        est.setSemestre(estTO.getSemestre());
        est.setGratuidad(estTO.getGratuidad());
        return est;
    }

    // normal -> ligero
    private EstudianteLigeroTO convertirLigero(Estudiante10 est){
        EstudianteLigeroTO ligero = new EstudianteLigeroTO();
        ligero.setCedula(est.getCedula());
        ligero.setGratuidad(est.getGratuidad());
        return ligero;
    }

    
    
        
    
}
