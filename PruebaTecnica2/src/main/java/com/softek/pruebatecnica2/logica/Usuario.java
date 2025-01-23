
package com.softek.pruebatecnica2.logica;


public class Usuario {
    private Long id;
    private String email;
    private String password;
    
    
    //constructor vacio

    public Usuario() {
    }

    //constructor atributos

    public Usuario(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    //geter y seter
    public void setPassword(String password) {
        this.password = password;
    }

    //tostring
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", password=" + password + '}';
    }
    
}