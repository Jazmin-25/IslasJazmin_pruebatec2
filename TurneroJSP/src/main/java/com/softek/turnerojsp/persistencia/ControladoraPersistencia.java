
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

    public List<Ciudadano> traerCiudadanos() {
       return ciudadJpa.findCiudadanoEntities();
                
    }
    
}
