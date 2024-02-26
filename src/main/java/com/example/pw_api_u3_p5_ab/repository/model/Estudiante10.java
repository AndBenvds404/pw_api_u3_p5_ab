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
@Table(name = "estudiante10")
public class Estudiante10 {
    @Id
    @GeneratedValue(generator = "seq_estudiante10", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_estudiante10", sequenceName = "seq_estudiante10", allocationSize = 1)
    @Column(name = "estu_id")
    private Integer id;

    @Column(name = "estu_nombre")
    private String nombre;

    @Column(name = "estu_apellido")
    private String apellido;

    @Column(name = "estu_cedula")
    private String cedula;

    @Column(name = "estu_genero")
    private String genero;

    @Column(name = "estu_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    @Column(name = "estu_sangre")
    private String sangre;

    @Column(name = "estu_matricula")
    private String matricula;

    @Column(name = "estu_semestre")
    private Byte semestre;

    @Column(name = "estu_gratuidad")
    private Boolean gratuidad;
    
    //get set
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
