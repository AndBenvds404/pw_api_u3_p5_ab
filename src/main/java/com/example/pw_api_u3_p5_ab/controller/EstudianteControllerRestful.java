package com.example.pw_api_u3_p5_ab.controller;
 
import org.springframework.web.bind.annotation.RestController;
 
import com.example.pw_api_u3_p5_ab.repository.modelo.Estudiante;
import com.example.pw_api_u3_p5_ab.service.IEstudianteService;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
//API: por el proyecto

@RestController

//Path clase = Servicio
@RequestMapping(path="/estudiantes")
public class EstudianteControllerRestFul {
 
    @Autowired
    private IEstudianteService estudianteService;
 


    //Metodosd = capacidades

    @GetMapping(path="/consultar/{id}")  
    public Estudiante buscar(@PathVariable Integer id){
        return estudianteService.buscar(id);
    }
 
   // http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar

    @PostMapping(path="/guardar")
    public void guardar(@RequestBody Estudiante estudiante){
        this.estudianteService.guardar(estudiante);
    }

    @PutMapping(path="/actualizar")
    public void actualizar(@RequestBody Estudiante estudiante){
        this.estudianteService.actualizar(estudiante);
    }


    @PatchMapping(path = "/actualizarParcial")
    public void actualizarParcial (@RequestBody Estudiante estudiante){

        this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), estudiante.getId());

    }


    @DeleteMapping(path = "/borrar")
    public void borrar (){
        this.estudianteService.borrar(1);
    }


    //filtrar un conjunto/lista los datos
    @GetMapping(path = "consultarTodos")
    // http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodos?genero=f&edad=15
    public List<Estudiante> consultarTodos(@RequestParam String genero, @RequestParam Integer edad ){
        System.out.println(edad);
        return this.estudianteService.buscarTodos(genero);
    }
 
   
}
 