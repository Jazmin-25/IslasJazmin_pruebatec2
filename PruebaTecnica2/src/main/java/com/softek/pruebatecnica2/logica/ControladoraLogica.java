package com.softek.pruebatecnica2.logica;

import com.softek.pruebatecnica2.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControladoraLogica { //es el main

//genero el vinculo entre controlpersistencia y logica
    ControladoraPersistencia controlPersi = new ControladoraPersistencia();
    

    public void crearCiudadano(String nombre, String apellido, String telefono) {
         // Inicio una lista vacía para los turnos, para evitar el erro
        List<Turno> listaTurnos = new ArrayList<>(); // Creamos el ciudadano con la lista vacía
        Ciudadano ciudad = new Ciudadano();
        ciudad.setNombre(nombre);
        ciudad.setApellido(apellido);
        ciudad.setTelefono(telefono);

        controlPersi.crearCiudadano(ciudad);
    }
    //mostrarCiudadano
    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {
        List<Ciudadano> ciudadanosCoincidentes = new ArrayList<>(); 
        ciudadanosCoincidentes = controlPersi.buscarPorApellido(busquedaApellido);

        return ciudadanosCoincidentes;
    }
    
    //eliminarCiudadano
    public void eliminarCiudadano(Long id) {
        controlPersi.eliminarCiudadano(id);
    }

    public Ciudadano buscarCiudadano(Long id) {
        return controlPersi.traerCiudadano(id);
    }
    //editarCiudadano

    public void editarCiudadano(Ciudadano ciudad) {
        controlPersi.editarCiudadano(ciudad);
    }
    
    
    
    /////---------------------USUARIO-----------------------
    public Usuario buscarUsuario(String email) {
      //return usuJpa.findUserByEmail(email);
    }
 /////---------------------TURNOS-----------------------
    public List<Turno> listaTurnos() {
          return controlPersi.obtenerTodosLosTurnos();
    }

    public void crearTurnos(String numeroTurno, String tramiteDescripcion, String fechaHora, String estado, Long ciudadanoId, Long tramiteId, Long usuarioId) {
        Turno turno = new Turno();
        Ciudadano ciudad = controlPersi.traerCiudadanoId(ciudadanoId);
        Ciudadano ciudadano = controlPersi.traerCiudadanoId(ciudadanoId);
        Tramite tramite = controlPersi.traerTramiteId(tramiteId);
        Tramite tramite = controlPersi.traerTramiteId(tramiteId);
        Usuario usuario = controlPersi.traerUsuarioId(usuarioId);
        Usuario usuario = controlPersi.traerUsuarioId(usuarioId);
        Turno turno = new Turno();
        turno.setNumeroTurno(numeroTurno);
        turno.setNumeroTurno(numeroTurno);
        turno.setTramiteDescripcion(tramiteDescripcion);
        turno.setTramiteDescripcion(tramiteDescripcion);
        turno.setFechaHora(fechaHora);
        turno.setFechaHora(fechaHora);
        turno.setEstado(estado);
        turno.setEstado(estado);
        turno.setCiudadano(ciudadanoId);
        turno.setCiudadano(ciudadano);
        turno.setTramite(tramiteId);
        turno.setTramite(tramite);
        turno.setUsuario(usuarioId);
        turno.setUsuario(usuario);
        
        controlPersi.crearTurno(turno);
        controlPersi.crearTurno(turno);
        

        
    }

    public List<Turno> busquedaAtendido(String buscarEstado) {
       //Filtrado desde la logica con lambdas y streams
       return controlPersi.busquedaAtendido().stream() 
        .filter(turn -> turn.getEstado().equals()) 
        .collect(Collectors.toList());

       
        List<Turno> turnosCoincidentes = new ArrayList<>();
        turnosCoincidentes = controlPersi.busquedaAtendido(busquedaAtendido);
        
        return turnosCoincidentes;

    }

    public List<Turno> obtenerTodosLosTurnos() {
     return controlPersi.obtenerTodosLosTurnos();
             
    }
}
