package com.example.dependencia.Compra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CompraConfig {

    @Bean
    public Jaxb2Marshaller marshallerCompra(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // revisar en el pom.xml <packageName>
        marshaller.setContextPath("vv.mx.uv.consumo.wsdl");
        return marshaller;
    }

    @Bean
    public CompraCliente clienteCompra(Jaxb2Marshaller marshallerCompra){
        CompraCliente c = new CompraCliente();
        // URI donde está el servicio
        c.setDefaultUri("https://compras-production-b296.up.railway.app/ws/compras");
        c.setMarshaller(marshallerCompra);
        c.setUnmarshaller(marshallerCompra);
        return c;
    }
    
}
