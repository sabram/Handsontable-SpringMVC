package com.shaunabram.handsontable.controller;

import com.shaunabram.handsontable.model.Request;
import com.shaunabram.handsontable.model.Result;
import com.shaunabram.handsontable.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SimpleController {

    private final SimpleService simpleService;

    @Autowired
    public SimpleController(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @SuppressWarnings("unused")
    @RequestMapping(value = "/")
    public String home() {
        System.out.println("Handsontable SimpleController: Passing through");
        //without viewResolver bean it would be:
        // return "WEB-INF/views/Handsontable.jsp";
        return "Handsontable";
    }

    @RequestMapping(method = RequestMethod.POST, value = "processRequest")
    @ResponseBody
    public Result processRequest(@RequestBody Request request) {
        Result result = simpleService.process(request);
        return result;
    }
}
