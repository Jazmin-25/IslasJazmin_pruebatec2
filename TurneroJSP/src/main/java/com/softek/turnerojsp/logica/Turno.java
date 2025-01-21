
package com.softek.turnerojsp.logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numero_turno;
    private String fecha_hora;
    private String estado;
    //constructor vacio
    public Turno() {
    }
    //constructor con atributos
     public Turno(Long id, Long numero_turno, String fecha_hora, String estado) {
        this.id = id;
        this.numero_turno = numero_turno;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
    }
    //geters y seter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero_turno() {
        return numero_turno;
    }

    public void setNumero_turno(Long numero_turno) {
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

   //tostring

    @Override
    public String toString() {
        return "Turno{" + "id=" + id + ", numero_turno=" + numero_turno + ", fecha_hora=" + fecha_hora + ", estado=" + estado + '}';
    }
    

    
}
