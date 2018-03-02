package com.singham.yuan.spring.boot.web.service.server.config;

import com.singham.yuan.spring.boot.web.service.server.interceptor.HandleEndPointInterceptor;
import com.singham.yuan.spring.boot.web.service.server.interceptor.LogEndPointInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

    @Autowired
    private HandleEndPointInterceptor handleEndPointInterceptor;

    @Autowired
    private LogEndPointInterceptor logEndPointInterceptor;

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        //配置对外服务根路径
        return new ServletRegistrationBean(servlet, "/server/*");
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(handleEndPointInterceptor);
        interceptors.add(logEndPointInterceptor);
        super.addInterceptors(interceptors);
    }

    @Bean(name = "springBoot")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("Test");
        wsdl11Definition.setLocationUri("/server");
        wsdl11Definition.setTargetNamespace("http://www.yuan.singham.com/service");
        wsdl11Definition.setSchema(countriesSchema);
        wsdl11Definition.setServiceName("SpringBoot");
        wsdl11Definition.setCreateSoap11Binding(false);
        wsdl11Definition.setCreateSoap12Binding(true);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("TestBody.xsd"));
    }

}
