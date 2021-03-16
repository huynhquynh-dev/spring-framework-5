package com.lionhuynh.springframework5.services;

import com.lionhuynh.springframework5.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PrimaryGreetingService implements GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public PrimaryGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
