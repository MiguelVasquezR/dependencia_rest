package com.example.dependencia.BD;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Compra {

    @Id
    private String id;
    private String idVendedor;
    private String idComprador;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdVendedor() {
        return idVendedor;
    }
    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }
    public String getIdComprador() {
        return idComprador;
    }
    public void setIdComprador(String idComprador) {
        this.idComprador = idComprador;
    }

    
    
}
