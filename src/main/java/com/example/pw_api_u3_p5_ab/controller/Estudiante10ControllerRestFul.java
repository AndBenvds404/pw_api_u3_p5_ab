package com.example.pw_api_u3_p5_ab.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p5_ab.repository.model.Estudiante;
import com.example.pw_api_u3_p5_ab.service.IEstudiante10Service;
import com.example.pw_api_u3_p5_ab.service.to.Estudiante10TO;
import com.example.pw_api_u3_p5_ab.service.to.EstudianteLigeroTO;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping(path="/estudiantes10")
@CrossOrigin
public class Estudiante10ControllerRestFul {
    @Autowired
    private IEstudiante10Service estudianteService;

    @GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)   
    public ResponseEntity<Estudiante10TO> consular(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.buscar(id));
    }

    @GetMapping(path="/ligeros/{id}",produces = MediaType.APPLICATION_JSON_VALUE)   
    public ResponseEntity<EstudianteLigeroTO> consularLigero(@PathVariable Integer id){
        EstudianteLigeroTO ligero = this.estudianteService.buscarLigero(id);
        Link link = linkTo(methodOn(Estudiante10ControllerRestFul.class).consular(id)).withRel("estudiante completo");
        ligero.add(link);
        return ResponseEntity.status(HttpStatus.OK).body(ligero);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Estudiante10TO>> consultarTodos() {
        var ls = this.estudianteService.consultarTodoTO();
        HttpHeaders heder = new HttpHeaders();
        heder.add("mensaje 242", "Recurso encontrado, lista creada");
        heder.add("info", "sistema en linea");
        return new ResponseEntity<>(ls,heder,242); 
    }
    

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void guardar(@RequestBody Estudiante10TO estudiante) {
        //TODO: process POST request
        this.estudianteService.guardar(estudiante);
    }
    
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(@RequestBody Estudiante10TO estudianteTo, @PathVariable Integer id) {   
        estudianteTo.setId(id); 
        this.estudianteService.actualizar(estudianteTo);
    }

    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable Integer id){
        this.estudianteService.borrar(id);
    }



}
