package com.example.pw_api_u3_p5_ab.controller;
 
import org.springframework.web.bind.annotation.RestController;
 
import com.example.pw_api_u3_p5_ab.repository.modelo.Estudiante;
import com.example.pw_api_u3_p5_ab.service.IEstudianteService;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
//API: por el proyecto
//servicio -> controller: clase controller
@RestController//Servicio
@RequestMapping(path="/estudiantes")
public class EstudianteControllerRestFul {
 
    @Autowired
    private IEstudianteService estudianteService;
 
    @GetMapping(path="/buscar")  
    public Estudiante buscar(){
        return estudianteService.buscar(1);
    }
 
    @PostMapping(path="/guardar")
    public void guardar(Estudiante estudiante){
        this.estudianteService.guardar(estudiante);
    }
 
   
}
 