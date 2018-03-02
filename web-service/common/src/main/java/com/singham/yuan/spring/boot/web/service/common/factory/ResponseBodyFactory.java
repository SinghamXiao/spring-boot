package com.singham.yuan.spring.boot.web.service.common.factory;

import com.singham.yuan.service.ResponseBody;
import com.singham.yuan.service.ResponseInfo;

public class ResponseBodyFactory {

    public static ResponseBody newResponseBody() {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setLevel("Level");
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setBirthday("2010-10-01");
        responseInfo.setCity("Nanjing");
        responseInfo.setCountry("CHN");
        responseInfo.setAge(10);
        responseBody.setResponseInfo(responseInfo);
        return responseBody;
    }

}
