package com.example.pw_api_u3_p5_ab.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pw_api_u3_p5_ab.repository.modelo.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ProfesorRepositoryImpl implements IProfesorRespository {


    @PersistenceContext
	private EntityManager entityManager;

    @Override
    public void insertar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.entityManager.persist(profesor);
    }

    @Override
    public Profesor seleccionar(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Profesor.class, id);
    }

    @Override
    public void actualizar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.entityManager.merge(profesor);
    }

    @Override
    public void actualizarParcial(Integer id, String materia, String salario) {
        // TODO Auto-generated method stub
        var query = this.entityManager.createQuery("UPDATE Profesor p SET p.materia =: valor1, p.salario =: valor2 WHERE p.id =: valor3");
		query.setParameter("valor1", materia);
		query.setParameter("valor2", salario);
		query.setParameter("valor3", id);
		query.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.seleccionar(id));
    }

    @Override
    public List<Profesor> consultarMateria(String materia) {
        // TODO Auto-generated method stub
        TypedQuery<Profesor> query = this.entityManager.createQuery("SELECT p FROM Profesor p WHERE p.materia =: valor", Profesor.class);
		query.setParameter("valor", materia);
		return query.getResultList();
    }
    
}
