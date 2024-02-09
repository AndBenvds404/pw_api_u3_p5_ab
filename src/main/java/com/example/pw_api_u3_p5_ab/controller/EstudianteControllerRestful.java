package com.example.pw_api_u3_p5_ab.controller;
 
import org.springframework.web.bind.annotation.RestController;
 
import com.example.pw_api_u3_p5_ab.repository.modelo.Estudiante;
import com.example.pw_api_u3_p5_ab.service.IEstudianteService;
import com.example.pw_api_u3_p5_ab.service.IMateriaService;
import com.example.pw_api_u3_p5_ab.service.to.EstudianteTo;
import com.example.pw_api_u3_p5_ab.service.to.MateriaTo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private IMateriaService materiaService;
 


    //Metodosd = capacidades

    @GetMapping(path="/{id}", produces = "application/xml")  
    public ResponseEntity<Estudiante> buscar(@PathVariable Integer id){
        Estudiante estudiante = estudianteService.buscar(id);
        return ResponseEntity.status(240).body(estudiante);
    }
 
   // http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void guardar(@RequestBody Estudiante estudiante){
        this.estudianteService.guardar(estudiante);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
    public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id){
        //estudiante.setId(id);
        this.estudianteService.actualizar(estudiante);
    }


    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
    public void actualizarParcial (@RequestBody Estudiante estudiante, @PathVariable Integer id){

        this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), id);

    }


    @DeleteMapping(path = "/{id}")
    public void borrar (@PathVariable Integer id){
        this.estudianteService.borrar(id);
    }


    //filtrar un conjunto/lista los datos
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    // http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodos?genero=f&edad=15
    public ResponseEntity< List<Estudiante>> consultarTodos(@RequestParam (required = false, defaultValue = "m") String genero ){
        List<Estudiante> lista = this.estudianteService.buscarTodos(genero);
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Mensaje_respuesta_242","lista consultada positivamente" );

        return new ResponseEntity<>(lista,cabeceras,HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodos?genero=f&edad=15
    public ResponseEntity< List<EstudianteTo>> consultarTodosHateoas(){
        List<EstudianteTo> lista = this.estudianteService.buscarTodosTo();
        

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<  List<MateriaTo>> consultarMateriaPorId(@PathVariable Integer id){

        var lista = this.materiaService.buscarPorIdEstudiante(id);
        System.out.println(lista);
        return ResponseEntity.status(HttpStatus.OK).body(lista) ;
    }
 
   
}
 