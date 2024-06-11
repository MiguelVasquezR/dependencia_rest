package com.example.dependencia.Inventario;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class InventarioConfig {

    @Bean
    public Jaxb2Marshaller marshallerInventario() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // revisar en el pom.xml <packageName>
        marshaller.setContextPath("xx.mx.uv.consumo.wsdl");
        return marshaller;
    }

    @Bean
    public InventarioCliente clienteInventario(Jaxb2Marshaller marshallerInventario) {
        InventarioCliente c = new InventarioCliente();
        // URI donde está el servicio
        c.setDefaultUri("https://inventarioserviciointegracion-production.up.railway.app/ws/inventario");
        c.setMarshaller(marshallerInventario);
        c.setUnmarshaller(marshallerInventario);
        return c;
    }

}
