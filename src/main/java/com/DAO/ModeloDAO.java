package com.DAO;
import com.model.*;


import jakarta.persistence.*;

import java.util.List;

public class ModeloDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ModeloDAO(){
        emf = Persistence.createEntityManagerFactory("modeloPU");
        em = emf.createEntityManager();
    }

    public void salvar(Modelo modelo){
        em.getTransaction().begin();
        em.persist(modelo);
        em.getTransaction().commit();
    }

    public List<Modelo> buscarTodos(){
        return em.createQuery("SELECT m FROM modelo m", Modelo.class).getResultList();
    }

    public Modelo buscarPorId(int id){
        return em.find(Modelo.class, id);
    }

    public void fechar(){
        em.close();
        emf.close();
    }
}
