package com.example.pw_api_u3_p5_ab.service;

import java.util.List;

import com.example.pw_api_u3_p5_ab.repository.modelo.Profesor;

public interface IProfesorService {

    public void guardar(Profesor profesor);
	public Profesor buscar(Integer id);
	public void actualizar(Profesor profesor);
	public void actualizarDatosPersonales(Integer id, String materia, String salario);
	public void borrar(Integer id);
	public List<Profesor>consultarMateria(String materia);
    
}
