package com.singham.yuan.spring.boot.web.service.common.factory;

import com.singham.yuan.service.RequestBody;
import com.singham.yuan.service.RequestInfo;

public class RequestBodyFactory {

    public static RequestBody newRequestBody() {
        RequestBody testBody = new RequestBody();
        testBody.setLevel("Level");
        RequestInfo personInfo = new RequestInfo();
        personInfo.setName("Nanjing");
        personInfo.setAge(30);
        testBody.setInfo(personInfo);
        return testBody;
    }

}
