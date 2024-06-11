package com.example.dependencia.Inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import vv.mx.uv.consumo.wsdl.SolicitarCompraRequest;
import vv.mx.uv.consumo.wsdl.SolicitarCompraResponse;
import xx.mx.uv.consumo.wsdl.ObtenerFoliosRequest;
import xx.mx.uv.consumo.wsdl.ObtenerFoliosResponse;
import xx.mx.uv.consumo.wsdl.ValidarFolioRequest;
import xx.mx.uv.consumo.wsdl.ValidarFolioResponse;

public class InventarioCliente extends WebServiceGatewaySupport {

    @Autowired
    private Jaxb2Marshaller marshallerInventario;

    public SolicitarCompraResponse solicitarCompra(SolicitarCompraRequest request) {
        try {
            return (SolicitarCompraResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(request, new SoapActionCallback("http://localhost:8280/ws/compras"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ObtenerFoliosResponse obtenerFolios(String num) {
        try {
            ObtenerFoliosRequest request = new ObtenerFoliosRequest();
            request.setNumOrden(num);

            return (ObtenerFoliosResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(request, new SoapActionCallback("https://inventarioserviciointegracion-production.up.railway.app/ws/inventario"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ValidarFolioResponse validarFolio(String folio) {
        try {
            ValidarFolioRequest request = new ValidarFolioRequest();
            request.setFolio(folio);
            return (ValidarFolioResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(request, new SoapActionCallback("https://inventarioserviciointegracion-production.up.railway.app/ws/inventario"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}
