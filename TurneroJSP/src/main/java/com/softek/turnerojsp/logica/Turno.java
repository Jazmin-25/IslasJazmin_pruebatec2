
package com.softek.turnerojsp.logica;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Turno implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroTurno;
    private String fecha_hora;
    private String estado; //en espera o atendido
    
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

    public Turno(String numeroTurno, String fecha_hora, String estado, Tramite tramite, Ciudadano ciudadano, Usuario usuario) {
        this.numeroTurno = numeroTurno;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.tramite = tramite;
        this.ciudadano = ciudadano;
        this.usuario = usuario;
    }

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

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}