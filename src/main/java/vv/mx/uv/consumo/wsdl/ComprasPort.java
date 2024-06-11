
package vv.mx.uv.consumo.wsdl;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "comprasPort", targetNamespace = "t4is.uv.mx/compras")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ComprasPort {


    /**
     * 
     * @param solicitudFacturaRequest
     * @return
     *     returns vv.mx.uv.consumo.wsdl.SolicitudFacturaResponse
     */
    @WebMethod(operationName = "SolicitudFactura")
    @WebResult(name = "SolicitudFacturaResponse", targetNamespace = "t4is.uv.mx/compras", partName = "SolicitudFacturaResponse")
    public SolicitudFacturaResponse solicitudFactura(
        @WebParam(name = "SolicitudFacturaRequest", targetNamespace = "t4is.uv.mx/compras", partName = "SolicitudFacturaRequest")
        SolicitudFacturaRequest solicitudFacturaRequest);

    /**
     * 
     * @param dependenciaProductosRequest
     * @return
     *     returns vv.mx.uv.consumo.wsdl.DependenciaProductosResponse
     */
    @WebMethod(operationName = "DependenciaProductos")
    @WebResult(name = "DependenciaProductosResponse", targetNamespace = "t4is.uv.mx/compras", partName = "DependenciaProductosResponse")
    public DependenciaProductosResponse dependenciaProductos(
        @WebParam(name = "DependenciaProductosRequest", targetNamespace = "t4is.uv.mx/compras", partName = "DependenciaProductosRequest")
        DependenciaProductosRequest dependenciaProductosRequest);

    /**
     * 
     * @param enviarDatosInventarioRequest
     * @return
     *     returns vv.mx.uv.consumo.wsdl.EnviarDatosInventarioResponse
     */
    @WebMethod(operationName = "EnviarDatosInventario")
    @WebResult(name = "EnviarDatosInventarioResponse", targetNamespace = "t4is.uv.mx/compras", partName = "EnviarDatosInventarioResponse")
    public EnviarDatosInventarioResponse enviarDatosInventario(
        @WebParam(name = "EnviarDatosInventarioRequest", targetNamespace = "t4is.uv.mx/compras", partName = "EnviarDatosInventarioRequest")
        EnviarDatosInventarioRequest enviarDatosInventarioRequest);

    /**
     * 
     * @param solicitarCompraRequest
     * @return
     *     returns vv.mx.uv.consumo.wsdl.SolicitarCompraResponse
     */
    @WebMethod(operationName = "SolicitarCompra")
    @WebResult(name = "SolicitarCompraResponse", targetNamespace = "t4is.uv.mx/compras", partName = "SolicitarCompraResponse")
    public SolicitarCompraResponse solicitarCompra(
        @WebParam(name = "SolicitarCompraRequest", targetNamespace = "t4is.uv.mx/compras", partName = "SolicitarCompraRequest")
        SolicitarCompraRequest solicitarCompraRequest);

}