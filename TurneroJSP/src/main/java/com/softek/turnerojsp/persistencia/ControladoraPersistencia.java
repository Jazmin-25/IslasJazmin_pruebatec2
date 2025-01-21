
package com.softek.turnerojsp.persistencia;

import com.softek.turnerojsp.logica.Ciudadano;
import com.softek.turnerojsp.logica.Usuario;
import com.softek.turnerojsp.persistencia.exceptions.NonexistentEntityException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {

    CiudadanoJpaController ciudadJpa = new CiudadanoJpaController();
    UsuarioJpaController usuJpa = new UsuarioJpaController();
  //  UsuarioJpaController usuJpa = new UsuarioJpaController();
    
    public void crearCiudadano(Ciudadano ciudad) {
       //llamo jpaController y le paso a la persona para crearlo
       ciudadJpa.create(ciudad);
    }
//con el metodo 1 logico menos recomendable
    public List<Ciudadano> traerCiudadanos() {
       return ciudadJpa.findCiudadanoEntities();
                
    }

    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {
        return ciudadJpa.findCiudadanoByApellido(busquedaApellido);

         }
//borrado fisico, debo hacer borrado logico
    public void eliminarCiudadano(Long id) {
        try {
            ciudadJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Ciudadano traerCiudadano(Long id) {
       return ciudadJpa.findCiudadano(id);
    }
    
    //editarciudadano
    public void editarCiudadano(Ciudadano ciudad) {
        try {
            ciudadJpa.edit(ciudad);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /////---------------------USUARIO-----------------------
    public Usuario buscarUsuario(String email) {
      return usuJpa.findUserByEmail(email);
    }

}
