package com.example.pw_api_u3_p5_ab.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pw_api_u3_p5_ab.repository.model.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements IProfesorRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.entityManager.persist(profesor);
    }

    @Override
    public void actualizar(Profesor profesor) {
        // TODO Auto-generated method stub
        this.entityManager.merge(profesor);
    }

    @Override
    public void actualizarParcial(String nombre, String apellido, Integer id) {
        // TODO Auto-generated method stub
        // SQL: UPDATE estudiante e set e.estu_nombre=:valor1, e.estu_apellido=:valor2 WHERE e.estu_id=:valor3
        Query query = this.entityManager.createQuery("UPDATE Profesor e SET e.nombre =: valor1, e.apellido =: valor2 WHERE e.id =: valor3");
        query.setParameter("valor1", nombre);
        query.setParameter("valor2", apellido);
        query.setParameter("valor3", id);
        query.executeUpdate(); //retorna un numero (los registros que se han actualizado)
    }

    @Override
    public Profesor seleccionar(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Profesor.class, id);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.seleccionar(id));
    }

    @Override
    public List<Profesor> consultarTodo(String genero)  {
        // TODO Auto-generated method stub
        var query = this.entityManager.createQuery("SELECT e Profesor FROM Profesor e WHERE e.genero = :variable", Profesor.class);
        query.setParameter("variable", genero);
        return query.getResultList();
    }
    
}
