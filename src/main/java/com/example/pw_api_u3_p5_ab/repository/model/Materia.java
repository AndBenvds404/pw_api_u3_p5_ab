package com.example.pw_api_u3_p5_ab.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "materia")
@JsonIgnoreProperties(value = "estudiante")
public class Materia {

     @Id
    @GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
    @Column(name = "mate_id")
    private Integer id;
    
    @Column(name = "mate_nombre")
    private String nombre;
    
    @Column(name = "mate_credito")
    private Integer credito;

    @ManyToOne
    @JoinColumn(name="mate_id_estudiante")
    private Estudiante estudiante;

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

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
    
}
