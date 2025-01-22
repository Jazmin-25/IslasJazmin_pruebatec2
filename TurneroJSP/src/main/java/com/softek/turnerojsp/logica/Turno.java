
package com.softek.turnerojsp.logica;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private NumeroTurno numero_turno;
    private String fecha_hora;
    private String estado; //en espera o atendido
    //el turno puede ver el tramite
    private Tramite untramite;
    
    @ManyToOne (cascade = CascadeType.ALL)
    
    @JoinColumn(name = "ciudadano_id", nullable = false)
    private Ciudadano ciudadano;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "tramite_id", nullable = false)
    private Tramite tramite;
    
    
    //constructor vacio
    public Turno() {
    }
    //constructor con atributos

 public Turno(Long id, NumeroTurno numero_turno, String fecha_hora, String estado, Tramite untramite, Ciudadano ciudadano, Usuario usuario, Tramite tramite) {
        this.id = id;
        this.numero_turno = numero_turno;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.untramite = untramite;
        this.ciudadano = ciudadano;
        this.usuario = usuario;
        this.tramite = tramite;
    }
   
    //geters y seter
public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NumeroTurno getNumero_turno() {
        return numero_turno;
    }

    public void setNumero_turno(NumeroTurno numero_turno) {
        this.numero_turno = numero_turno;
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

    public Tramite getUntramite() {
        return untramite;
    }

    public void setUntramite(Tramite untramite) {
        this.untramite = untramite;
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

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    //Mi idea es que se ordene de la siguiente manera:
//Turno id=1, número de turno='Turno_1', fecha y hora='2023-11-22 10:30:00', 
//estado='en espera', trámite='Renovación de licencia', ciudadano='Juan Pérez', usuario='María López'}
    
    
}
