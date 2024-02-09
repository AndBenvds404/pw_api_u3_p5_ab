package com.example.pw_api_u3_p5_ab.service;

import java.util.List;

import com.example.pw_api_u3_p5_ab.repository.modelo.Materia;
import com.example.pw_api_u3_p5_ab.service.to.MateriaTo;

public interface IMateriaService {
    public List<MateriaTo> buscarPorIdEstudiante(Integer id);
}
