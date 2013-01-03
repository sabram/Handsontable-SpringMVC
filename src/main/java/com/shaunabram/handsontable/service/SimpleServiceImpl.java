package com.shaunabram.handsontable.service;

import com.shaunabram.handsontable.model.Request;
import com.shaunabram.handsontable.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleServiceImpl implements SimpleService {

    @Override
    public Result process(Request request) {
        List<Object[]> data = request.getData();
        String description = request.getDescription();
        Result result = new Result(description, data);
        return result;
    }

}
