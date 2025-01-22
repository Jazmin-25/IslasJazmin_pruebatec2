
package com.softek.turnerojsp.persistencia;

import com.softek.turnerojsp.logica.Ciudadano;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.softek.turnerojsp.logica.Turno;
import com.softek.turnerojsp.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CiudadanoJpaController implements Serializable {

    public CiudadanoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public CiudadanoJpaController(){
        emf = Persistence.createEntityManagerFactory("turneroJspPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ciudadano ciudadano) {
        if (ciudadano.getListaturnos() == null) {
            ciudadano.setListaturnos(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turno> attachedListaturnos = new ArrayList<Turno>();
            for (Turno listaturnosTurnoToAttach : ciudadano.getListaturnos()) {
                listaturnosTurnoToAttach = em.getReference(listaturnosTurnoToAttach.getClass(), listaturnosTurnoToAttach.getId());
                attachedListaturnos.add(listaturnosTurnoToAttach);
            }
            ciudadano.setListaturnos(attachedListaturnos);
            em.persist(ciudadano);
            for (Turno listaturnosTurno : ciudadano.getListaturnos()) {
                Ciudadano oldCiudadanoOfListaturnosTurno = listaturnosTurno.getCiudadano();
                listaturnosTurno.setCiudadano(ciudadano);
                listaturnosTurno = em.merge(listaturnosTurno);
                if (oldCiudadanoOfListaturnosTurno != null) {
                    oldCiudadanoOfListaturnosTurno.getListaturnos().remove(listaturnosTurno);
                    oldCiudadanoOfListaturnosTurno = em.merge(oldCiudadanoOfListaturnosTurno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ciudadano ciudadano) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudadano persistentCiudadano = em.find(Ciudadano.class, ciudadano.getId());
            List<Turno> listaturnosOld = persistentCiudadano.getListaturnos();
            List<Turno> listaturnosNew = ciudadano.getListaturnos();
            List<Turno> attachedListaturnosNew = new ArrayList<Turno>();
            for (Turno listaturnosNewTurnoToAttach : listaturnosNew) {
                listaturnosNewTurnoToAttach = em.getReference(listaturnosNewTurnoToAttach.getClass(), listaturnosNewTurnoToAttach.getId());
                attachedListaturnosNew.add(listaturnosNewTurnoToAttach);
            }
            listaturnosNew = attachedListaturnosNew;
            ciudadano.setListaturnos(listaturnosNew);
            ciudadano = em.merge(ciudadano);
            for (Turno listaturnosOldTurno : listaturnosOld) {
                if (!listaturnosNew.contains(listaturnosOldTurno)) {
                    listaturnosOldTurno.setCiudadano(null);
                    listaturnosOldTurno = em.merge(listaturnosOldTurno);
                }
            }
            for (Turno listaturnosNewTurno : listaturnosNew) {
                if (!listaturnosOld.contains(listaturnosNewTurno)) {
                    Ciudadano oldCiudadanoOfListaturnosNewTurno = listaturnosNewTurno.getCiudadano();
                    listaturnosNewTurno.setCiudadano(ciudadano);
                    listaturnosNewTurno = em.merge(listaturnosNewTurno);
                    if (oldCiudadanoOfListaturnosNewTurno != null && !oldCiudadanoOfListaturnosNewTurno.equals(ciudadano)) {
                        oldCiudadanoOfListaturnosNewTurno.getListaturnos().remove(listaturnosNewTurno);
                        oldCiudadanoOfListaturnosNewTurno = em.merge(oldCiudadanoOfListaturnosNewTurno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = ciudadano.getId();
                if (findCiudadano(id) == null) {
                    throw new NonexistentEntityException("The ciudadano with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudadano ciudadano;
            try {
                ciudadano = em.getReference(Ciudadano.class, id);
                ciudadano.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ciudadano with id " + id + " no longer exists.", enfe);
            }
            List<Turno> listaturnos = ciudadano.getListaturnos();
            for (Turno listaturnosTurno : listaturnos) {
                listaturnosTurno.setCiudadano(null);
                listaturnosTurno = em.merge(listaturnosTurno);
            }
            em.remove(ciudadano);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ciudadano> findCiudadanoEntities() {
        return findCiudadanoEntities(true, -1, -1);
    }

    public List<Ciudadano> findCiudadanoEntities(int maxResults, int firstResult) {
        return findCiudadanoEntities(false, maxResults, firstResult);
    }

    private List<Ciudadano> findCiudadanoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ciudadano.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ciudadano findCiudadano(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ciudadano.class, id);
        } finally {
            em.close();
        }
    }

    public int getCiudadanoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ciudadano> rt = cq.from(Ciudadano.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    //método para filtrar ciudadanos por apellido en la BD
    public List<Ciudadano> findCiudadanoByApellido (String busquedaApellido) {
        EntityManager em =getEntityManager();
        
        try {
            //consulta JPQL para buscar por apellido
            String consulta = "SELECT per FROM Ciudadano per WHERE per.apellido = :busquedaApellido";
            Query query = em.createQuery(consulta);
            query.setParameter("busquedaApellido",busquedaApellido);
            
            return query.getResultList();
        } finally {
            em.close();
        } 
}
}