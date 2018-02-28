package com.singham.yuan.spring.boot.web.service.common.factory;

import com.singham.yuan.body.PersonInfo;
import com.singham.yuan.body.TestBody;

public class TestBodyFactory {

    public static TestBody newTestBody() {
        TestBody testBody = new TestBody();
        testBody.setLevel("Level");
        PersonInfo personInfo = new PersonInfo();
        personInfo.setBirthday("2010-10-01");
        personInfo.setCity("Nanjing");
        personInfo.setCountry("CHN");
        personInfo.setComment("No Comments");
        testBody.setPersonInfo(personInfo);
        return testBody;
    }

}
