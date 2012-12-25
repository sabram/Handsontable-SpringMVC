package com.shaunabram.handsontable.controller;

import com.shaunabram.handsontable.service.HelloWorldService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.Map;

import static org.easymock.EasyMock.*;
import static org.fest.assertions.api.Assertions.assertThat;

public class HelloWorldControllerTest {

    HelloWorldService mockHelloWorldService;
    HelloWorldController helloWorldController;

    @Before
    public void initialize() {
        mockHelloWorldService = createStrictMock(HelloWorldService.class);
        helloWorldController = new HelloWorldController(mockHelloWorldService);
    }

    @Test
    public void greeting_adds_service_result_to_model() {
        //set up test data
        String msg = "msg";

        //record the expected behavior
        expect(mockHelloWorldService.getGreeting(msg)).andReturn(msg);

        //switch to replay state
        replay(mockHelloWorldService);

        //call the methods under test
        Model model = new ExtendedModelMap();
        helloWorldController.greeting("msg", model);

        //verify expectations
        verify(mockHelloWorldService);
        Map<String,Object> map = model.asMap();
        assertThat(map.get("msg")).isEqualTo(msg);
    }

    @Test
    public void greeting_return_correct_view_name() {
        String expectedViewName = "HelloWorld";
        Model model = new ExtendedModelMap();
        String actualViewName = helloWorldController.greeting("msg", model);
        assertThat(actualViewName).isEqualTo(expectedViewName);
    }
}
