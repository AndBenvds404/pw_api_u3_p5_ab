package com.example.pw_api_u3_p5_ab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.pw_api_u3_p5_ab.repository.modelo.Profesor;
import com.example.pw_api_u3_p5_ab.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorControllerREstFul {

    @Autowired
	private IProfesorService profesorService;

	// http://localhost:8080/API/v1.0/Matricula/profesores

	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Profesor profesor) {
		this.profesorService.guardar(profesor);
	}

	@GetMapping(path = "/buscar/{id}")
	public Profesor buscar(@PathVariable Integer id) {
		return this.profesorService.buscar(id);
	}

	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Profesor profesor) {
		this.profesorService.actualizar(profesor);
	}

	@PatchMapping(path = "/actualizarParcial")
	public void actualizarDatosPersonales(@RequestBody Profesor profesor) {
		this.profesorService.actualizarDatosPersonales(profesor.getId(), profesor.getMateria(), profesor.getSalario());
	}

	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.profesorService.borrar(id);
	}

	@GetMapping(path = "/consultarMateria")
	public List<Profesor> buscarPorMateria(@RequestParam String materia){
		return this.profesorService.consultarMateria(materia);
	}

    
}