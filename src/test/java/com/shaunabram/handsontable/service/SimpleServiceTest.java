package com.shaunabram.handsontable.service;

import com.shaunabram.handsontable.model.Request;
import com.shaunabram.handsontable.model.Result;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class SimpleServiceTest {

    SimpleService simpleService;

    @Before
    public void initialize() {
        simpleService = new SimpleServiceImpl();
    }

    @Test
    public void process_returns_Result_mirroring_Request() {
        //setup test data
        String requestDescription = "requestDescription";
        List<Object[]> requestData = new ArrayList<>();
        Object[] row1 = {"Data1"};
        Object[] row2 = {"Data2"};
        requestData.add(row1);
        requestData.add(row2);
        Request request = new Request(requestDescription, requestData);

        //call the methods under test
        Result result = simpleService.process(request);

        //verify expectations
        assertThat(result.getDescription()).isEqualTo(requestDescription);
        assertThat(result.getData()).isEqualTo(requestData);
    }

}
