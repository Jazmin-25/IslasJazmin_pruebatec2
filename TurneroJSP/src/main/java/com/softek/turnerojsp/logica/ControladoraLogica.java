
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

    //filtrado en la logica opcion 1 la menos eficiente
    /*public ArrayList<Ciudadano> buscarPorApellido(String busquedaApellido) {
       ArrayList<Ciudadano> ciudadanosCoincidentes = new ArrayList<>(); //se puede hacer con programacion funcional
        List<Ciudadano> listaCiudadanos = controlPersi.traerCiudadanos();
        
       for (Ciudadano ciudad : listaCiudadanos) {
           if (ciudad.getApellido().equals(busquedaApellido)){
               ciudadanosCoincidentes.add(ciudad);
           }
       }
       return ciudadanosCoincidentes;
    }
*/
    /*opción 2
        Paso este dato a la lógica, la lógica le pide a la persistencia que traiga SOLO LOS DATOS QUE COINCIDAN,
        y la lógica solo responde los datos ya filtrados desde la BD 
        */
      //la base de datos se encarga de traer todo filtrado
    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {
    List<Ciudadano> ciudadanosCoincidentes = new ArrayList<>(); //se puede hacer con programacion funcional
      ciudadanosCoincidentes = controlPersi.buscarPorApellido(busquedaApellido);
        
        return ciudadanosCoincidentes;
    }

    public void eliminarCiudadano(Long id) {
        controlPersi.eliminarCiudadano(id);
    }

    public Ciudadano buscarCiudadano(Long id) {
        return controlPersi.traerCiudadano(id);
    }

}