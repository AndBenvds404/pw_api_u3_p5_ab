package com.example.pw_api_u3_p5_ab.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

public class EstudianteTO  extends RepresentationModel<EstudianteTO>
                            implements Serializable{
    //ID para mandarlo por por la red para q se vuelva binario y regresar
    private static final long serialVersionUID = 1456841518L;
    
    private Integer id;
    private String nombre;
    private String apellido;
    private String genero;
    private LocalDateTime fechaNacimiento;

    
    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getGenero() {
        return genero;
    }
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


}
