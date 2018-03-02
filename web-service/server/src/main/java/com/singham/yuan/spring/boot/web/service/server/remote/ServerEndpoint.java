package com.singham.yuan.spring.boot.web.service.server.remote;

import com.singham.yuan.service.RequestBody;
import com.singham.yuan.service.ResponseBody;
import com.singham.yuan.service.TestBody;
import com.singham.yuan.spring.boot.web.service.common.factory.ResponseBodyFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.ws.soap.SOAPBinding;

@Endpoint(value = SOAPBinding.SOAP12HTTP_BINDING)
public class ServerEndpoint {

    private static final String NAMESPACE_URI = "http://www.yuan.singham.com/service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TestBody")
    @ResponsePayload
    public TestBody execute(@RequestPayload TestBody request) {
        return request;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RequestBody")
    @ResponsePayload
    public ResponseBody execute(@RequestPayload RequestBody request) {
        return ResponseBodyFactory.newResponseBody();
    }
}
