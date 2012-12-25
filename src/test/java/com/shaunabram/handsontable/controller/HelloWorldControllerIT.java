package com.shaunabram.handsontable.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/appServlet/servlet-context.xml"})
// http://stackoverflow.com/questions/10385452/location-of-spring-context-xml
public class HelloWorldControllerIT {

    @Autowired
    HelloWorldController helloWorldController;

    @Test
    public void greeting_throws_no_exceptions_when_all_autowired() {
        String msg = "msg";
        Model model = new ExtendedModelMap();
        helloWorldController.greeting(msg, model);
    }
}
