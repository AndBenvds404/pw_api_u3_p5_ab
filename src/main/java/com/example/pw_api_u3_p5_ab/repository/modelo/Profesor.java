package com.example.pw_api_u3_p5_ab.repository.modelo; 


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {

	@Id
	@GeneratedValue(generator = "seq_prof", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_prof", sequenceName = "seq_prof", allocationSize = 1)
	@Column(name = "prof_id")
	private Integer id;

	@Column(name = "prof_nombre")
	private String nombre;

	@Column(name = "prof_apellido")
	private String apellido;

	@Column(name = "prof_edad")
	private Integer edad;

	@Column(name = "prof_genero")
	private String genero;

	@Column(name = "prof_materia")
	private String materia;

	@Column(name = "prof_carga_horaria")
	private String cargaHoraria;

	@Column(name = "prof_salario")
	private String salario;


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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }



}