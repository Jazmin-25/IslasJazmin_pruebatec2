
package com.softek.turnerojsp.logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    
    
    //constructor vacio
    public Tramite() {
    }
    //constructor con atributos
    public Tramite(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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

    //to string
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
}
