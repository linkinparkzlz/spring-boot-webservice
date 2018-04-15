package com.example.springbootwebservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.WsdlDefinition;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class WebServicesConfiguration extends WsConfigurerAdapter {


    @Bean("user")
    @Autowired
    public Wsdl11Definition userWsdl11Definition(XsdSchema userXsdSchema) {

        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();

        wsdl11Definition.setPortTypeName("UserServicePort");

        wsdl11Definition.setLocationUri("/web-services");

        wsdl11Definition.setTargetNamespace("http://segmentfault.com/schemas");

        wsdl11Definition.setSchema(userXsdSchema);

        return wsdl11Definition;


    }


    /**
     * 暴露Schema
     *
     * @return
     */
    @Bean
    public XsdSchema userXsdSchema() {

        return new SimpleXsdSchema(new ClassPathResource("META-INFO/schemas/user.xsd"));
    }


}



























