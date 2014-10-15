package com.ontarget.api.dao;

import com.ontarget.api.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class HelloDaoTest extends BaseTest{


    @Autowired
    private HelloDao helloDao;


    @Test
    public void testHello(){
        String msg=helloDao.getHello();
        assertTrue(msg!=null);
    }

}