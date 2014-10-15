package com.ontarget.api.service;

import com.ontarget.api.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Owner on 10/14/14.
 */
@Service
public class HelloService {

    @Autowired
    HelloDao helloDao;


    public String getHello(){
        return helloDao.getHello();
    }

}
