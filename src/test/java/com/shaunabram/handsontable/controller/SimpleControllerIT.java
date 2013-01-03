package com.shaunabram.handsontable.controller;

import com.shaunabram.handsontable.model.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/appServlet/servlet-context.xml"})
// http://stackoverflow.com/questions/10385452/location-of-spring-context-xml
public class SimpleControllerIT {

    @Autowired
    SimpleController simpleController;

    @Test
    public void process_throws_no_exceptions_when_all_autowired() {
        String description = "description";
        List<Object[]> data = new ArrayList<>();
        Request request = new Request(description, data);
        simpleController.processRequest(request);
    }
}
