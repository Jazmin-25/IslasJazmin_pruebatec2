
package com.softek.pruebatecnica2.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroTurno;
    private String fechaHora;
    private String tramiteDescripcion;
    private String estado;
     // relación con Ciudadano (Muchos a un)
    @ManyToOne
    @JoinColumn(name = "ciudadano_id")
    private Ciudadano ciudadano;
    
    //el turno puede ver el tramite
    // Relación con Tramite (Uno a uno)
    @OneToOne
    @JoinColumn(name = "tramite_id")
    private Tramite tramite;

    // relación con Usuario (Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    
    //constructor vacio
    public Turno() {
    }
        
    //constructor atributos 
     public Turno(Long id, String numeroTurno, String fechaHora, String tramiteDescripcion, String estado) {
        this.id = id;
        this.numeroTurno = numeroTurno;
        this.fechaHora = fechaHora;
        this.tramiteDescripcion = tramiteDescripcion;
        this.estado = estado;
    }


    //geter y seter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(String numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTramiteDescripcion() {
        return tramiteDescripcion;
    }

    public void setTramiteDescripcion(String tramiteDescripcion) {
        this.tramiteDescripcion = tramiteDescripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   //tostring

    @Override
    public String toString() {
        return "Turno{" + "id=" + id + ", numeroTurno=" + numeroTurno + ", fechaHora=" + fechaHora + ", tramiteDescripcion=" + tramiteDescripcion + ", estado=" + estado + '}';
    }
   

}
