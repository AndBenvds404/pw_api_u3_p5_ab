                                                                                                                                                                                                                                                                        package com.example.pw_api_u3_p5_ab.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;


public class Estudiante10TO extends RepresentationModel<Estudiante10TO> implements Serializable{
    
                                
    private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String genero;
    private LocalDateTime fechaNacimiento;
    private String sangre;
    private String matricula;
    private Byte semestre;
    private Boolean gratuidad;

 
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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getSangre() {
        return sangre;
    }
    public void setSangre(String sangre) {
        this.sangre = sangre;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public Byte getSemestre() {
        return semestre;
    }
    public void setSemestre(Byte semestre) {
        this.semestre = semestre;
    }
    public Boolean getGratuidad() {
        return gratuidad;
    }
    public void setGratuidad(Boolean gratuidad) {
        this.gratuidad = gratuidad;
    }

    
    
}
