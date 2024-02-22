package com.example.pw_api_u3_p5_ab.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pw_api_u3_p5_ab.repository.model.Estudiante10;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class Estudiante10RepositoryImpl implements IEstudiante10Repository{

   @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Estudiante10 estudiante) {
        // TODO Auto-generated method stub
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante10 estudiante) {
        // TODO Auto-generated method stub
        this.entityManager.merge(estudiante);
    }

    @Override
    public Estudiante10 buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Estudiante10.class, id);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.buscar(id));
    }

    @Override
    public List<Estudiante10> consultarTodo()  {
        // TODO Auto-generated method stub
        var query = this.entityManager.createQuery("SELECT e FROM Estudiante10 e", Estudiante10.class);
        return query.getResultList();
    }
    
}
