
package com.softek.pruebatecnica2.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tramite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTramite;
    private String tipoTramite;
    
    //constructor vacio
     public Tramite() {
    }
    
    //constructor atributos     
 public Tramite(Long idTramite, String tipoTramite) {
        this.idTramite = idTramite;
        this.tipoTramite = tipoTramite;
    }

    //geter y seter
    
    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

       //tostring

    @Override
    public String toString() {
        return "Tramite{" + "idTramite=" + idTramite + ", tipoTramite=" + tipoTramite + '}';
    }
      
}
