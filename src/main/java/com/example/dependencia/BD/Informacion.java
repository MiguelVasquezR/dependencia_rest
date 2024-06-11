package com.example.dependencia.BD;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Informacion {

    @Id
    private String id;
    private String nombre;
    private String direccion;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
