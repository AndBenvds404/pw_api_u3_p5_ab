package com.example.pw_api_u3_p5_ab.service;

import java.util.List;

import com.example.pw_api_u3_p5_ab.service.to.MateriaTO;

public interface IMateriaService {

    public List<MateriaTO> selecionarPorIDEstrudiante(Integer id);
}