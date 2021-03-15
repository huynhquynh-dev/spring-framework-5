package com.lionhuynh.springframework5.controllers;

import com.lionhuynh.springframework5.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(@Qualifier("greetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello(){
        System.out.println("Hello!!! ");

        return greetingService.sayGreeting();
    }
}
