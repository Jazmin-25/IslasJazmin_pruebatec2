
package com.softek.turnerojsp.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.softek.turnerojsp.logica.Tramite;
import com.softek.turnerojsp.logica.Ciudadano;
import com.softek.turnerojsp.logica.Turno;
import com.softek.turnerojsp.logica.Usuario;
import com.softek.turnerojsp.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TurnoJpaController implements Serializable {

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public TurnoJpaController(){
        emf = Persistence.createEntityManagerFactory("turneroJspPU");
    }
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tramite tramite = turno.getTramite();
            if (tramite != null) {
                tramite = em.getReference(tramite.getClass(), tramite.getId());
                turno.setTramite(tramite);
            }
            Ciudadano ciudadano = turno.getCiudadano();
            if (ciudadano != null) {
                ciudadano = em.getReference(ciudadano.getClass(), ciudadano.getId());
                turno.setCiudadano(ciudadano);
            }
            Usuario usuario = turno.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getId());
                turno.setUsuario(usuario);
            }
            em.persist(turno);
            if (tramite != null) {
                Turno oldTurnoOfTramite = tramite.getTurno();
                if (oldTurnoOfTramite != null) {
                    oldTurnoOfTramite.setTramite(null);
                    oldTurnoOfTramite = em.merge(oldTurnoOfTramite);
                }
                tramite.setTurno(turno);
                tramite = em.merge(tramite);
            }
            if (ciudadano != null) {
                ciudadano.getListaturnos().add(turno);
                ciudadano = em.merge(ciudadano);
            }
            if (usuario != null) {
                usuario.getTurnos().add(turno);
                usuario = em.merge(usuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getId());
            Tramite tramiteOld = persistentTurno.getTramite();
            Tramite tramiteNew = turno.getTramite();
            Ciudadano ciudadanoOld = persistentTurno.getCiudadano();
            Ciudadano ciudadanoNew = turno.getCiudadano();
            Usuario usuarioOld = persistentTurno.getUsuario();
            Usuario usuarioNew = turno.getUsuario();
            if (tramiteNew != null) {
                tramiteNew = em.getReference(tramiteNew.getClass(), tramiteNew.getId());
                turno.setTramite(tramiteNew);
            }
            if (ciudadanoNew != null) {
                ciudadanoNew = em.getReference(ciudadanoNew.getClass(), ciudadanoNew.getId());
                turno.setCiudadano(ciudadanoNew);
            }
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getId());
                turno.setUsuario(usuarioNew);
            }
            turno = em.merge(turno);
            if (tramiteOld != null && !tramiteOld.equals(tramiteNew)) {
                tramiteOld.setTurno(null);
                tramiteOld = em.merge(tramiteOld);
            }
            if (tramiteNew != null && !tramiteNew.equals(tramiteOld)) {
                Turno oldTurnoOfTramite = tramiteNew.getTurno();
                if (oldTurnoOfTramite != null) {
                    oldTurnoOfTramite.setTramite(null);
                    oldTurnoOfTramite = em.merge(oldTurnoOfTramite);
                }
                tramiteNew.setTurno(turno);
                tramiteNew = em.merge(tramiteNew);
            }
            if (ciudadanoOld != null && !ciudadanoOld.equals(ciudadanoNew)) {
                ciudadanoOld.getListaturnos().remove(turno);
                ciudadanoOld = em.merge(ciudadanoOld);
            }
            if (ciudadanoNew != null && !ciudadanoNew.equals(ciudadanoOld)) {
                ciudadanoNew.getListaturnos().add(turno);
                ciudadanoNew = em.merge(ciudadanoNew);
            }
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getTurnos().remove(turno);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getTurnos().add(turno);
                usuarioNew = em.merge(usuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = turno.getId();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
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
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Tramite tramite = turno.getTramite();
            if (tramite != null) {
                tramite.setTurno(null);
                tramite = em.merge(tramite);
            }
            Ciudadano ciudadano = turno.getCiudadano();
            if (ciudadano != null) {
                ciudadano.getListaturnos().remove(turno);
                ciudadano = em.merge(ciudadano);
            }
            Usuario usuario = turno.getUsuario();
            if (usuario != null) {
                usuario.getTurnos().remove(turno);
                usuario = em.merge(usuario);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
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

    public Turno findTurno(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
