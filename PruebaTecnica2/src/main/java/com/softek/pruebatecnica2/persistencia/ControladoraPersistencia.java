package com.softek.pruebatecnica2.persistencia;

import com.softek.pruebatecnica2.logica.Ciudadano;
import com.softek.pruebatecnica2.logica.Tramite;
import com.softek.pruebatecnica2.logica.Turno;
import com.softek.pruebatecnica2.logica.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    //llamo a cada  JpaControler para que pase la informacion
    CiudadanoJpaController ciudadJpa = new CiudadanoJpaController();
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    TramiteJpaController tramJpa = new TramiteJpaController();
    TurnoJpaController turnJpa = new TurnoJpaController();

    public void crearCiudadano(Ciudadano ciudad) {
        //llamo jpaController y le paso a la persona para crearlo
        //  ciudadJpa.create(ciudad);
    }

    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {
        // return ciudadJpa.findCiudadanoEntities();      
    }

    public void eliminarCiudadano(Long id) {
        //try {
        // ciudadJpa.destroy(id);
        //   } catch (NonexistentEntityException ex) {
        //     Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }

    public Ciudadano traerCiudadano(Long id) {
        //  return ciudadJpa.findCiudadano(id);
    }

    public void editarCiudadano(Ciudadano ciudad) {
        // try {
        //  ciudadJpa.edit(ciudad);
        // } catch (Exception ex) {
        //   Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }

    public Ciudadano traerCiudadanoId(Long ciudadanoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Tramite traerTramiteId(Long tramiteId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Usuario traerUsuarioId(Long usuarioId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void crearTurno(Turno turno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Turno> obtenerTodosLosTurnos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
