package com.example.pw_api_u3_p5_ab.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class EstudianteLigeroTo  extends RepresentationModel<EstudianteLigeroTo> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre;

	// SET Y GET
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

}