package com.shaunabram.handsontable.controller;

import com.shaunabram.handsontable.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles requests for the HelloWorld example.
 */
@Controller
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping(value = "/")
    public String home() {
        System.out.println("HelloWorldController: Passing through");
        //without AppConfig view resolver
        // return "WEB-INF/views/HelloWorld.jsp";
        return "HelloWorld";
    }

    @RequestMapping(value = "/HelloWorld", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="msg", required=false) String msg, Model model) {
        String greeting = helloWorldService.getGreeting(msg);
        model.addAttribute("msg", greeting);
        return "HelloWorld";
    }

    @RequestMapping(value = "/jsontest1", method = RequestMethod.POST)
    public String jsontest1(@RequestParam(value="msg", required=false) String msg) {
        System.out.println("msg=" + msg);
        return "HelloWorld";
    }

    @RequestMapping(value = "/jsontest2", method = RequestMethod.POST)
    public String jsontest2(@RequestParam(value="msg1", required=false) String msg1,
                            @RequestParam(value="msg2", required=false) String msg2
    ) {
        System.out.println("msg1=" + msg1);
        System.out.println("msg2=" + msg2);
        return "HelloWorld";
    }

    @RequestMapping(value = "/jsontest3", method = RequestMethod.POST)
    public String jsontest3(@RequestParam(value="msg1", required=false) String msg1) {
        System.out.println("msg1=" + msg1);
        return "HelloWorld";
    }

    @RequestMapping(headers ={"Accept=application/json"}, value = "/jsontest4.json", method = RequestMethod.POST)
//    public String jsontest4(@RequestBody Object user) {
    public String jsontest4(@RequestParam(value="a", required=false) String a,
                            @RequestParam(value="b", required=false) String b) {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        return "HelloWorld";
    }

    @RequestMapping(value = "/jsontest5", method = RequestMethod.POST)
    public String jsontest5(@RequestParam(value="a", required=false) String a,
                            @RequestParam(value="b", required=false) Object[] b) {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        return "HelloWorld";
    }

    @RequestMapping(value = "/jsontest6", method = RequestMethod.POST)
    public String jsontest5(@RequestParam(value="a", required=false) Object[] b) {
        System.out.println("b=" + b);
        return "HelloWorld";
    }

    @RequestMapping(method = RequestMethod.POST, value = "jsontest7")
    @ResponseBody
    public Result math(@RequestBody final Request request) {
        final Result result = new Result();
        result.setAddition(request.getLeft() + request.getRight());
        result.setSubtraction(request.getLeft() - request.getRight());
        result.setMultiplication(request.getLeft() * request.getRight());

//        List<List<String>> aList = (List<List<String>>)request.getData();
//        Object[][] aList = (Object[][])request.getData();
        List<Object[]> b = request.getData();
        System.out.println(request.getData());
        result.setData(b);
        String description = request.getDescription();
        result.setDescription(description);
        return result;
    }
}
