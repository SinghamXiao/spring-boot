package com.singham.yuan.spring.boot.web.service.server.config;

import com.singham.yuan.spring.boot.web.service.common.service.HandleNsPrefixService;
import com.singham.yuan.spring.boot.web.service.common.service.TransformMessageService;
import com.singham.yuan.spring.boot.web.service.common.xml.NamespacePrefixMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import java.util.HashMap;

@Component
public class ServerConfig {

    @Bean(name = "messageFactory")
    public SaajSoapMessageFactory getSaajSoapMessageFactory() {
        SaajSoapMessageFactory saajSoapMessageFactory = new SaajSoapMessageFactory();
        HashMap<String, Object> messageProperties = new HashMap<>();
        messageProperties.put("javax.xml.soap.write-xml-declaration", "true");
        saajSoapMessageFactory.setMessageProperties(messageProperties);
        saajSoapMessageFactory.setSoapVersion(SoapVersion.SOAP_12);
        saajSoapMessageFactory.afterPropertiesSet();
        return saajSoapMessageFactory;
    }

    @Bean(name = "marshaller")
    public Jaxb2Marshaller getMarshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.singham.yuan.service");
        HashMap<String, Object> marshallerProperties = new HashMap<>();
        marshallerProperties.put("jaxb.fragment", true);
        marshallerProperties.put("jaxb.formatted.output", true);
        marshallerProperties.put("com.sun.xml.bind.namespacePrefixMapper", new NamespacePrefixMapperImpl());
        jaxb2Marshaller.setMarshallerProperties(marshallerProperties);
        return jaxb2Marshaller;
    }

    @Bean(name = "faultMarshaller")
    public Jaxb2Marshaller getClientFaultMarshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("org.xmlsoap.schemas.soap.envelope");
        return jaxb2Marshaller;
    }

    @Bean
    public HandleNsPrefixService getHandleNsPrefixService() {
        return new HandleNsPrefixService();
    }

    @Bean
    public TransformMessageService getTransformMessageService() {
        return new TransformMessageService();
    }

}
