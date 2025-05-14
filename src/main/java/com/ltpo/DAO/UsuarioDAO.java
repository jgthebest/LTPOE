package com.ltpo.DAO;

import com.ltpo.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class UsuarioDAO {

    private EntityManagerFactory emf;
    public EntityManager getEntityManager() {
        return emf.createEntityManager(); // Cria um novo EntityManager a partir do EntityManagerFactory
    }

    public UsuarioDAO(){
        emf = Persistence.createEntityManagerFactory("usuarioPU");
        EntityManager em = getEntityManager();
    }

    public void salvar(Usuario usuario){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        if (usuario.getId() == null) {
            em.persist(usuario);
        } else {
            em.merge(usuario);
        }
        em.getTransaction().commit();
    }

    public List<Usuario> buscarTodos(){
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    public Usuario buscarPorId(Integer id){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, id);
            em.getTransaction().commit();
            return usuario;
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
