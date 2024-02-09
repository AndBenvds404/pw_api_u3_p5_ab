package com.example.pw_api_u3_p5_ab.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;

public class MateriaTo implements Serializable {
    
    private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private Integer credito;
	
	//SET Y GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCredito() {
		return credito;
	}
	public void setCredito(Integer credito) {
		this.credito = credito;
	}
	

    
}
