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
public class Tramite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    //Un turno esta asociado a un tramite especifico
    //el lado propietario de la relación es la clase Turno
    @OneToOne(mappedBy = "tramite", cascade = CascadeType.ALL)
    private Turno turno;
   
    
    //constructor vacio
    public Tramite() {
    }
    
    //constructor con atributos

    public Tramite(String descripcion, Turno turno, Usuario usuario) {
        this.descripcion = descripcion;
        this.turno = turno;
    }
    
    //geters y seter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

}
