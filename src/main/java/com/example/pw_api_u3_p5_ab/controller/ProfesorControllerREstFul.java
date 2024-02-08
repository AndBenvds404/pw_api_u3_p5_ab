package com.example.pw_api_u3_p5_ab.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p5_ab.repository.modelo.Estudiante;
import com.example.pw_api_u3_p5_ab.repository.modelo.Profesor;
import com.example.pw_api_u3_p5_ab.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorControllerREstFul {

    @Autowired
	private IProfesorService profesorService;

	// http://localhost:8080/API/v1.0/Matricula/profesores

	@PostMapping (consumes = MediaType.APPLICATION_XML_VALUE)
	public void guardar(@RequestBody Profesor profesor) {
		this.profesorService.guardar(profesor);
	}

	@GetMapping(path = "/{id}", produces =  MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Profesor>  buscar(@PathVariable Integer id) {
		Profesor profesor = this.profesorService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(profesor);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer id) {
		profesor.setId(id);
		this.profesorService.actualizar(profesor);
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarDatosPersonales(@RequestBody Profesor profesor, @PathVariable Integer id) {
		profesor.setId(id);
		this.profesorService.actualizarDatosPersonales(profesor.getId(), profesor.getMateria(), profesor.getSalario());
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.profesorService.borrar(id);
	}

	@GetMapping(path = "/consultarMateria", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Profesor>>  buscarPorMateria(@RequestParam String materia){
		 List<Profesor> lista = this.profesorService.consultarMateria(materia);
		 return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

    
}
