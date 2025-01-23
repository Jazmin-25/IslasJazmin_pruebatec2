package com.softek.pruebatecnica2.logica;

import com.softek.pruebatecnica2.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;

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
}
