package com.example.dependencia.Compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import vv.mx.uv.consumo.wsdl.SolicitarCompraRequest;
import vv.mx.uv.consumo.wsdl.SolicitarCompraResponse;

public class CompraCliente extends WebServiceGatewaySupport{

    @Autowired
     private Jaxb2Marshaller marshallerCompra;

     public SolicitarCompraResponse solicitarCompra(SolicitarCompraRequest request){
        try{
            return (SolicitarCompraResponse) getWebServiceTemplate()
            .marshalSendAndReceive(request, new SoapActionCallback("https://compras-production-b296.up.railway.app/ws/compras"));   
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            return null;
        }
     }

     
    
}
