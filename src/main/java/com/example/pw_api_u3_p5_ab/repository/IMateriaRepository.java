package com.example.pw_api_u3_p5_ab.repository;

import java.util.List;

import com.example.pw_api_u3_p5_ab.repository.model.Materia;

public interface IMateriaRepository {
    public List<Materia>  SeleccionarPorIdEstudiante(Integer id);
}
