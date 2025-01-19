
package com.softek.turnerojsp.persistencia;

import com.softek.turnerojsp.logica.Ciudadano;
import java.util.ArrayList;
import java.util.List;


public class ControladoraPersistencia {

    CiudadanoJpaController ciudadJpa = new CiudadanoJpaController();
    
    public void crearCiudadano(Ciudadano ciudad) {
       //llamo jpaController y le paso a la persona para crearlo
       ciudadJpa.create(ciudad);
    }
//con el metodo 1 logico menos recomendable
    public List<Ciudadano> traerCiudadanos() {
       return ciudadJpa.findCiudadanoEntities();
                
    }

    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {
        return ciudadJpa.findPersonaByApellido(busquedaApellido);

         }
    
}
