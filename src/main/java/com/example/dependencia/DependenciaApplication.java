package com.example.dependencia;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dependencia.BD.Compra;
import com.example.dependencia.BD.ICompra;
import com.example.dependencia.BD.IInformacion;
import com.example.dependencia.BD.IProducto;
import com.example.dependencia.BD.Informacion;
import com.example.dependencia.Compra.CompraCliente;
import com.example.dependencia.Inventario.InventarioCliente;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletResponse;
import vv.mx.uv.consumo.wsdl.SolicitarCompraRequest;
import vv.mx.uv.consumo.wsdl.SolicitarCompraResponse;
import xx.mx.uv.consumo.wsdl.ObtenerFoliosResponse;
import xx.mx.uv.consumo.wsdl.ValidarFolioResponse;

@RestController
@SpringBootApplication
public class DependenciaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DependenciaApplication.class, args);
    }

    private static Gson gson = new Gson();

    @Autowired
    CompraCliente cliente;

    @Autowired
    private InventarioCliente inventarioCliente;

    @Autowired
    private IInformacion informacion;

    @Autowired
    private IProducto productoAlmacen;

    @Autowired
    private ICompra compraAlmacen;

    @RequestMapping(value = "/solicitar-compra", method = RequestMethod.POST, consumes = { "application/json", "application/xml" })
    public void solicitarCompra(@RequestBody com.example.dependencia.BD.SolicitudCompra solicitud, HttpServletResponse response) throws IOException {

		System.out.println("Solicitud: " + solicitud.toString());

        SolicitarCompraRequest request = new SolicitarCompraRequest();
        SolicitarCompraRequest.InformacionComprador informacionComprador = new SolicitarCompraRequest.InformacionComprador();
        informacionComprador.setNombre(solicitud.getComprador().getNombre());
        informacionComprador.setDireccion(solicitud.getComprador().getDireccion());
        Informacion informacionCompradorBD = new Informacion();
        informacionCompradorBD.setNombre(informacionComprador.getNombre());
        informacionCompradorBD.setDireccion(informacionComprador.getDireccion());
        informacionCompradorBD.setId(UUID.randomUUID().toString());
        informacion.save(informacionCompradorBD);

        SolicitarCompraRequest.InformacionVendedor informacionVendedor = new SolicitarCompraRequest.InformacionVendedor();
        informacionVendedor.setNombre(solicitud.getVendedor().getNombre());
        informacionVendedor.setDireccion(solicitud.getVendedor().getDireccion());
        Informacion informacionVendedorBD = new Informacion();
        informacionVendedorBD.setNombre(informacionVendedor.getNombre());
        informacionVendedorBD.setDireccion(informacionVendedor.getDireccion());
        informacionVendedorBD.setId(UUID.randomUUID().toString());
        informacion.save(informacionVendedorBD);

        SolicitarCompraRequest.Productos.Producto productoSolicitud;
        SolicitarCompraRequest.Productos productosSolicitud = new SolicitarCompraRequest.Productos();

        Compra compra = new Compra();
        compra.setId(UUID.randomUUID().toString());
        compra.setIdComprador(informacionCompradorBD.getId());
        compra.setIdVendedor(informacionVendedorBD.getId());
        compraAlmacen.save(compra);

        com.example.dependencia.BD.Producto productoSolicitudModelo;
        for (com.example.dependencia.BD.Producto producto : solicitud.getProductos()) {
            productoSolicitud = new SolicitarCompraRequest.Productos.Producto();
            productoSolicitud.setNombre(producto.getNombre());
            productoSolicitud.setCantidad(String.valueOf(producto.getCantidad()));
            productoSolicitud.setPrecioUnitario(String.valueOf(producto.getPrecioUnitario()));
            productosSolicitud.getProducto().add(productoSolicitud);

            productoSolicitudModelo = new com.example.dependencia.BD.Producto();
            productoSolicitudModelo.setNombre(producto.getNombre());
            productoSolicitudModelo.setCantidad(producto.getCantidad());
            productoSolicitudModelo.setPrecioUnitario(producto.getPrecioUnitario());
            productoSolicitudModelo.setId(UUID.randomUUID().toString());
            productoSolicitudModelo.setIdCompra(compra.getId());
            productoAlmacen.save(productoSolicitudModelo);
        }

        request.setInformacionComprador(informacionComprador);
        request.setInformacionVendedor(informacionVendedor);
        request.setProductos(productosSolicitud);

        SolicitarCompraResponse respuesta = cliente.solicitarCompra(request);
        response.getWriter().write(gson.toJson(respuesta.getMensaje()));
    }

    @RequestMapping(value = "/obtener-folios/{orderNum}", method = RequestMethod.GET)
    public void obtenerFolios(@PathVariable("orderNum") String orderNum, HttpServletResponse response) throws IOException {
        ObtenerFoliosResponse respuesta = inventarioCliente.obtenerFolios(orderNum);
        response.getWriter().write(gson.toJson(respuesta.getProductos()));
    }

    @RequestMapping(value = "/validar-folio/{folio}", method = RequestMethod.GET)
    public void validarFolio(@PathVariable("folio") String folio, HttpServletResponse response) throws IOException {
        ValidarFolioResponse respuesta = inventarioCliente.validarFolio(folio);
        response.getWriter().write(gson.toJson(respuesta.getMensaje()));
    }
}
