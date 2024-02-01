package com.example.pw_api_u3_p5_ab.repository;

import java.util.List;

import com.example.pw_api_u3_p5_ab.repository.modelo.Profesor;

public interface IProfesorRespository {

    public void insertar(Profesor profesor);
	public Profesor seleccionar(Integer id);
	public void actualizar(Profesor profesor);
	public void actualizarParcial(Integer id, String materia, String salario);
	public void eliminar(Integer id);
	public List<Profesor> consultarMateria(String materia);
}
