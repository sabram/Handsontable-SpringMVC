package com.shaunabram.handsontable.controller;

import com.shaunabram.handsontable.model.Request;
import com.shaunabram.handsontable.model.Result;
import com.shaunabram.handsontable.service.SimpleService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.fest.assertions.api.Assertions.assertThat;

public class SimpleControllerTest {

    SimpleService mockSimpleService;
    SimpleController simpleController;

    @Before
    public void initialize() {
        mockSimpleService = createStrictMock(SimpleService.class);
        simpleController = new SimpleController(mockSimpleService);
    }

    @Test
    public void processRequest_returns_result_from_service() {
        //set up test data
        String description = "description";
        List<Object[]> data = new ArrayList<>();
        Request request = new Request(description, data);
        Result expectedResult =  new Result(description, data);

        //record the expected behavior
        expect(mockSimpleService.process(request)).andReturn(expectedResult);

        //switch to replay state
        replay(mockSimpleService);

        //call the methods under test
        Result actualResult = simpleController.processRequest(request);

        //verify expectations
        verify(mockSimpleService);
        assertThat(expectedResult).isEqualTo(actualResult);
    }
}
