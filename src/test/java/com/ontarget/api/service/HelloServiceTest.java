package com.ontarget.api.service;

import com.ontarget.api.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class HelloServiceTest extends BaseTest{

    @Autowired
    HelloService helloService;

    @Test
    public void testHello(){
        String msg = helloService.getHello();
        assertTrue(msg!=null);
    }

}