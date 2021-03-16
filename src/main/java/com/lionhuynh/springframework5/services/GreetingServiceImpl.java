package com.lionhuynh.springframework5.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello Gurus!!!! - Original";
    }
}
