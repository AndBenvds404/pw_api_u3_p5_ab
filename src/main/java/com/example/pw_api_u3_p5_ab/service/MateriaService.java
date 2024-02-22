package com.example.pw_api_u3_p5_ab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p5_ab.repository.MateriaRepository;
import com.example.pw_api_u3_p5_ab.repository.model.Materia;
import com.example.pw_api_u3_p5_ab.service.to.MateriaTO;

@Service
public class MateriaService implements IMateriaService{

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public List<MateriaTO> selecionarPorIDEstrudiante(Integer id) {
        // TODO Auto-generated method stub
        List<Materia> ls = this.materiaRepository.SeleccionarPorIdEstudiante(id);
		List<MateriaTO> lsFinal = new ArrayList<>();
		for(Materia mat : ls) {
			lsFinal.add(this.convertir(mat));
		}
		return lsFinal;    
    }
    private MateriaTO convertir(Materia materia) {
		MateriaTO mat = new MateriaTO();
		mat.setCredito(materia.getCredito());
		mat.setId(materia.getId());
		mat.setNombre(materia.getNombre());
		return mat;
	}
    
}
