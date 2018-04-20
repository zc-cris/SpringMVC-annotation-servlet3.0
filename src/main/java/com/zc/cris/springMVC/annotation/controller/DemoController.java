package com.zc.cris.springMVC.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zc.cris.springMVC.annotation.service.DemoService;

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;
    
    @ResponseBody
    @RequestMapping("/demo")
    public String demo() {
        return demoService.demo("cris");
    }
    
    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
