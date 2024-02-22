package com.example.pw_api_u3_p5_ab.service.to;
import org.springframework.hateoas.RepresentationModel;
import java.io.Serializable;

public class EstudianteLigeroTO extends RepresentationModel<Estudiante10TO> implements Serializable{

    private static final long serialVersionUID = 1456841518L;
    private String cedula;
    private Boolean gratuidad;
    
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Boolean getGratuidad() {
        return gratuidad;
    }
    public void setGratuidad(Boolean gratuidad) {
        this.gratuidad = gratuidad;
    }
    
    
}
