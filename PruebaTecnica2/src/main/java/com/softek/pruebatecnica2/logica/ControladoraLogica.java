package com.softek.pruebatecnica2.logica;

import com.softek.pruebatecnica2.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControladoraLogica { //es el main

  // Genero el vínculo entre controlpersistencia y lógica
    ControladoraPersistencia controlPersi = new ControladoraPersistencia();

    public void crearCiudadano(String nombre, String apellido, String telefono) {
        // Inicio una lista vacía para los turnos, para evitar errores
        List<Turno> listaTurnos = new ArrayList<>(); // Creamos el ciudadano con la lista vacía
        Ciudadano ciudad = new Ciudadano();
        ciudad.setNombre(nombre);
        ciudad.setApellido(apellido);
        ciudad.setTelefono(telefono);

        controlPersi.crearCiudadano(ciudad);
    }

    // Mostrar ciudadano
    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {
        List<Ciudadano> ciudadanosCoincidentes = new ArrayList<>();
        ciudadanosCoincidentes = controlPersi.buscarPorApellido(busquedaApellido);
        return ciudadanosCoincidentes;
    }

    // Eliminar ciudadano
    public void eliminarCiudadano(Long id) {
        controlPersi.eliminarCiudadano(id);
    }

    // Buscar ciudadano
    public Ciudadano buscarCiudadano(Long id) {
        return controlPersi.traerCiudadano(id);
    }

    // Editar ciudadano
    public void editarCiudadano(Ciudadano ciudad) {
        controlPersi.editarCiudadano(ciudad);
    }
       
    /////---------------------TURNOS-----------------------
    // Aquí puedes agregar los métodos relacionados con los turnos

    public void crearTurnos(String numeroTurno, String tramiteDescripcion, String fechaHora, String estado, Long ciudadanoId, Long tramiteId, Long usuarioId) {
        
    }
    

} 