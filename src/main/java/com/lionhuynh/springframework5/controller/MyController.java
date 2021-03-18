package com.lionhuynh.springframework5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getHomePage(){
        return "index";
    }
}
