package com.softek.pruebatecnica2.persistencia;

import com.softek.pruebatecnica2.logica.Ciudadano;
import com.softek.pruebatecnica2.logica.Tramite;
import com.softek.pruebatecnica2.logica.Turno;
import com.softek.pruebatecnica2.logica.Usuario;
import com.softek.pruebatecnica2.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ControladoraPersistencia {

    //llamo a cada  JpaControler para que pase la informacion
    CiudadanoJpaController ciudadJpa = new CiudadanoJpaController();
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    TramiteJpaController tramJpa = new TramiteJpaController();
    TurnoJpaController turnJpa = new TurnoJpaController();

    public void crearCiudadano(Ciudadano ciudad) {
        //llamo jpaController y le paso a la persona para crearlo
        ciudadJpa.create(ciudad);
    }
    // Buscar ciudadanos por apellido (filtro básico)
    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {
        return ciudadJpa.findCiudadanoEntities().stream()
                .filter(ciudadano -> ciudadano.getApellido().equalsIgnoreCase(busquedaApellido))
                .collect(Collectors.toList());
    }

    // Eliminar ciudadano
    public void eliminarCiudadano(Long id) {
        try {
            ciudadJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Ciudadano no encontrado", ex);
        }
    }

    // Buscar ciudadano por ID
    public Ciudadano traerCiudadano(Long id) {
        return ciudadJpa.findCiudadano(id);
    }

    // Editar ciudadano
    public void editarCiudadano(Ciudadano ciudad) {
        try {
            ciudadJpa.edit(ciudad);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al editar ciudadano", ex);
        }
    }

    // Traer ciudadano por ID (implementación básica)
    public Ciudadano traerCiudadanoId(Long ciudadanoId) {
        return ciudadJpa.findCiudadano(ciudadanoId);
    }

    // Traer trámite por ID (pendiente de implementación completa)
    public Tramite traerTramiteId(Long tramiteId) {
        return tramJpa.findTramite(tramiteId);
    }

    // Traer usuario por ID (pendiente de implementación completa)
    public Usuario traerUsuarioId(Long usuarioId) {
        return usuJpa.findUsuario(usuarioId);
    }

    // Crear turno (pendiente de implementación completa)
    public void crearTurno(Turno turno) {
        turnJpa.create(turno);
    }

    // Obtener todos los turnos
    public List<Turno> obtenerTodosLosTurnos() {
        return turnJpa.findTurnoEntities();
    }
}