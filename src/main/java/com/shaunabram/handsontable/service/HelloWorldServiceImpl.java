package com.shaunabram.handsontable.service;

import com.shaunabram.handsontable.persist.HelloWorldDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    private final HelloWorldDAO helloWorldDAO;

    @Autowired
    public HelloWorldServiceImpl(HelloWorldDAO helloWorldDAO) {
        this.helloWorldDAO = helloWorldDAO;
    }

    @Override
    public String getGreeting(String msg) {
        return helloWorldDAO.getGreeting(msg);
    }

}
