package com.ltpo.DAO;

import com.ltpo.model.Automovel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class AutomovelDAO {

    private EntityManagerFactory emf;
    public EntityManager getEntityManager() {
        return emf.createEntityManager(); // Cria um novo EntityManager a partir do EntityManagerFactory
    }

    public AutomovelDAO(){
        emf = Persistence.createEntityManagerFactory("automovelPU");
        EntityManager em = getEntityManager();
    }

    public void salvar(Automovel automovel){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        if (automovel.getId() == null) {
            em.persist(automovel);
        } else {
            em.merge(automovel);
        }
        em.getTransaction().commit();
    }

    public List<Automovel> buscarTodos(){
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT a FROM Automovel a", Automovel.class).getResultList();
    }

    public Automovel buscarPorId(Integer id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Automovel automovel = em.find(Automovel.class, id);
            em.getTransaction().commit();
            return automovel;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }



}
