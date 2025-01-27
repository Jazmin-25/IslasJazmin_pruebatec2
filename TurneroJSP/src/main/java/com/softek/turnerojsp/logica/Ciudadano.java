
package com.softek.turnerojsp.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciudadano implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String  telefono;
    //un ciudadano puede tener varios turbos y el turno puede ver al ciudadano 
    @OneToMany(mappedBy = "ciudadano", cascade = CascadeType.ALL) 
    private List<Turno> listaturnos;

    
    //Constructor vacio
    public Ciudadano() {
    }
    
    //Constructor con atributos

    public Ciudadano(Long id, String nombre, String apellido, String telefono, List<Turno> listaturnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.listaturnos = listaturnos;
    }

    
    public Long getId() {
        return id;
    }

    //geters y seters
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Turno> getListaturnos() {
        return listaturnos;
    }

    public void setListaturnos(List<Turno> listaturnos) {
        this.listaturnos = listaturnos;
    }
    
            
}
