package com.zc.cris.springMVC.annotation.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public String demo(String str) {
        return "hello,"+str;
    }
}
