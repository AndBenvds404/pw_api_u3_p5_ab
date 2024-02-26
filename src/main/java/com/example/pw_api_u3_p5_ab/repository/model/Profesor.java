package com.example.pw_api_u3_p5_ab.repository.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "profesor")
public class Profesor {
    
    @Id
    @GeneratedValue(generator = "seq_profesor", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_profesor", sequenceName = "seq_profesor", allocationSize = 1)
    @Column(name = "prof_id")
    private Integer id;

    @Column(name = "prof_nombre")
    private String nombre;

    @Column(name = "prof_apellido")
    private String apellido;

    @Column(name = "prof_genero")
    private String genero;

    @Column(name = "prof_materia")
    private String materia;

    @Column(name = "prof_cedula")
    private String cedula;

    @Column(name = "prof_curso")
    private String curso;

    @Column(name = "prof_fecha_contrato")
    private LocalDateTime fechaContrato;

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

    public String getMateria() {
        return materia;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCurso() {
        return curso;
    }

    public LocalDateTime getFechaContrato() {
        return fechaContrato;
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

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setFechaContrato(LocalDateTime fechaContrato) {
        this.fechaContrato = fechaContrato;
    }




}
