package com.example.dependencia.BD;

public class SolicitudCompra {

    private Informacion vendedor;
    private Informacion comprador;
    private java.util.List<Producto> productos;
    public Informacion getVendedor() {
        return vendedor;
    }
    public void setVendedor(Informacion vendedor) {
        this.vendedor = vendedor;
    }
    public Informacion getComprador() {
        return comprador;
    }
    public void setComprador(Informacion comprador) {
        this.comprador = comprador;
    }
    public java.util.List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(java.util.List<Producto> productos) {
        this.productos = productos;
    }
}
