
package com.softek.turnerojsp.logica;

import com.softek.turnerojsp.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;


public class ControladoraLogica {//es mi main
//genero el vinculo entre controlpersistencia y logica
    ControladoraPersistencia controlPersi = new ControladoraPersistencia();
    
    public void crearCiudadano(String nombre, String apellido, String telefono) {
        Ciudadano ciudad = new Ciudadano(nombre, apellido, telefono);
        controlPersi.crearCiudadano(ciudad);
    }

    //filtrado en la logica
    public ArrayList<Ciudadano> buscarPorApellido(String busquedaApellido) {
       ArrayList<Ciudadano> ciudadanosCoincidentes = new ArrayList<>(); //se puede hacer con programacion funcional
        List<Ciudadano> listaCiudadanos = controlPersi.traerCiudadanos();
        
       for (Ciudadano ciudad : listaCiudadanos) {
           if (ciudad.getApellido().equals(busquedaApellido)){
               ciudadanosCoincidentes.add(ciudad);
           }
       }
       return ciudadanosCoincidentes;
    }
}