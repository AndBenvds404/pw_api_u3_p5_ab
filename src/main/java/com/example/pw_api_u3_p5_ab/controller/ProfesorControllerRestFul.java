package com.example.pw_api_u3_p5_ab.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p5_ab.repository.model.Profesor;
import com.example.pw_api_u3_p5_ab.service.IProfesorService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController//Servicio
@RequestMapping(path="/profesores")
public class ProfesorControllerRestFul {

    //http://localhost:8080/API/v1.0/Matricula/profesores

    @Autowired
    private IProfesorService profesorService;

    // /1
    @GetMapping(path="/{id}",produces = "application/xml")
    public ResponseEntity<Profesor> consular(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(profesorService.buscar(id));
    }

    //
    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void guardar(@RequestBody Profesor profesor){
        this.profesorService.guardar(profesor);
    }

    // /2
    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer id) {        
        profesor.setId(id);
        this.profesorService.actualizar(profesor);
    }

    // /2
    @PatchMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarParcial(@RequestBody Profesor profesor, @PathVariable Integer id){
        profesor.setId(id);
        this.profesorService.actualizarParcial(profesor.getNombre(),profesor.getApellido(),profesor.getId());
    }

    // /5
    @DeleteMapping(path="/{id}")
    public void borrar(@PathVariable Integer id){
        this.profesorService.borrar(id);
    }

    // ?genero=M
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<Profesor>> consultarTodo(@RequestParam (required = false, defaultValue = "f") String genero) {
        var lista_prof = profesorService.consultarTodo(genero);
        HttpHeaders heder = new HttpHeaders();
        heder.add("mensaje 242", "Recurso encontrado, lista creada");
        heder.add("info", "sistema en linea");
        return new ResponseEntity<>(lista_prof,heder,242);
    }
}
