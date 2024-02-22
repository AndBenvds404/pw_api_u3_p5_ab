package com.example.pw_api_u3_p5_ab.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class MateriaTO extends RepresentationModel<MateriaTO>
                        implements Serializable{
    private static final long serialVersionUID = 1456841518L;
    
    private Integer id;
    private String nombre;
    private Integer credito;
    
    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public Integer getCredito() {
        return credito;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCredito(Integer credito) {
        this.credito = credito;
    }
    
}
