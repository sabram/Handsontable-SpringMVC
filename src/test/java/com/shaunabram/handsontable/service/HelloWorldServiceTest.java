package com.shaunabram.handsontable.service;

import com.shaunabram.handsontable.persist.HelloWorldDAO;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.fest.assertions.api.Assertions.assertThat;

public class HelloWorldServiceTest {

    HelloWorldDAO mockHelloWorldDAO;
    HelloWorldService helloWorldService;

    @Before
    public void initialize() {
        mockHelloWorldDAO = createStrictMock(HelloWorldDAO.class);
        helloWorldService = new HelloWorldServiceImpl(mockHelloWorldDAO);
    }

    @Test
    public void getGreeting_returns_dao_value() {
        //set up test data
        String msg = "msg";

        //record the expected behavior
        expect(mockHelloWorldDAO.getGreeting(msg)).andReturn(msg);

        //switch to replay state
        replay(mockHelloWorldDAO);

        //call the methods under test
        String greeting = helloWorldService.getGreeting(msg);

        //verify expectations
        verify(mockHelloWorldDAO);
        assertThat(greeting).isEqualTo(msg);
    }

}
