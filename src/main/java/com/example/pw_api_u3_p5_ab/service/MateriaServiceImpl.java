package com.example.pw_api_u3_p5_ab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pw_api_u3_p5_ab.repository.IMateriaRepository;
import com.example.pw_api_u3_p5_ab.repository.modelo.Materia;
import com.example.pw_api_u3_p5_ab.service.to.MateriaTo;

@Service
public class MateriaServiceImpl implements IMateriaService {
    
	
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public List<MateriaTo> buscarPorIdEstudiante(Integer id) {
		// TODO Auto-generated method stub
		List<Materia> ls = this.materiaRepository.seleccionarPorIdEstudiante(id);
		List<MateriaTo> lsFinal = new ArrayList<>();
		for(Materia mat : ls) {
			lsFinal.add(this.convertir(mat));
		}
		return lsFinal;
	}
	
	private MateriaTo convertir(Materia materia) {
		MateriaTo mat = new MateriaTo();
		mat.setCredito(materia.getCredito());
		mat.setId(materia.getId());
		mat.setNombre(materia.getNombre());
		return mat;
	}

    
    
}
